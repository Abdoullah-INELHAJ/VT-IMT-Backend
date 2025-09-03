package com.imt.vt_imt.service;

import com.imt.vt_imt.dto.RaceDetailDTO;
import com.imt.vt_imt.entity.Registration;
import com.imt.vt_imt.entity.User;
import com.imt.vt_imt.entity.Race;
import com.imt.vt_imt.entity.ResultEntry;
import com.imt.vt_imt.dto.ResultDTO;
import com.imt.vt_imt.repository.RaceRepository;
import com.imt.vt_imt.repository.RegistrationRepository;
import com.imt.vt_imt.repository.UserRepository;
import com.imt.vt_imt.repository.ResultRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;
import java.util.Random;

@Service
public class RaceService {
    private final RaceRepository raceRepo;
    private final RegistrationRepository registrationRepo;
    private final UserRepository userRepo;
    private final ResultRepository resultRepo;

    public RaceService(RaceRepository raceRepo, RegistrationRepository registrationRepo, UserRepository userRepo, ResultRepository resultRepo) {
        this.raceRepo = raceRepo;
        this.registrationRepo = registrationRepo;
        this.userRepo = userRepo;
        this.resultRepo = resultRepo;
    }

    public List<Race> listUpcoming() {
        var today = LocalDate.now();
        return raceRepo.findByDateAfterOrderByDateAsc(today.minusDays(1));
    }

    public Race create(String title, LocalDate date, String location, Integer capacity, String routeUrl) {
        Race r = Race.builder()
                .title(title)
                .date(date)
                .location(location)
                .capacity(capacity)
                .routeUrl(routeUrl)
                .createdAt(LocalDateTime.now())
                .build();
        return raceRepo.save(r);
    }

    public RaceDetailDTO detail(Long raceId) {
        var race = raceRepo.findById(raceId)
                .orElseThrow(() -> new IllegalArgumentException("Course introuvable"));

        return new RaceDetailDTO(
                race.getId(),
                race.getTitle(),
                race.getDate(),
                race.getLocation(),
                race.getCapacity(),
                race.getRouteUrl(),
               getParticipants(race)
        );
    }

     public void register(Long raceId, Long userId) {
        var race = raceRepo.findById(raceId)
                .orElseThrow(() -> new IllegalArgumentException("Course introuvable"));
        var user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        registrationRepo.findByRaceAndUser(race, user)
                .ifPresent(r -> { throw new IllegalArgumentException("Déjà inscrit"); });

        var registrations = registrationRepo.findByRace(race);
        if (registrations.size() >= race.getCapacity()) {
            throw new IllegalArgumentException("Plus de places disponibles");
        }

        Registration reg = Registration.builder()
                .race(race)
                .user(user)
                .registeredAt(LocalDateTime.now())
                .build();

        registrationRepo.save(reg);
    }

    public List<String> getParticipants(Race race) {
        return registrationRepo.findByRace(race).stream()
                .map(reg -> reg.getUser().getFullName())
                .toList();
    }

    public void simulateResults(Long raceId) {
        var race = raceRepo.findById(raceId)
                .orElseThrow(() -> new IllegalArgumentException("Course introuvable"));

        if (race.getDate().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Course pas encore terminée");
        }

        if (!resultRepo.findByRaceOrderByRankPositionAsc(race).isEmpty()) {
            throw new IllegalArgumentException("Résultats déjà simulés");
        }

        var registrations = registrationRepo.findByRace(race);
        if (registrations.isEmpty()) {
            throw new IllegalArgumentException("Aucun participant à simuler");
        }

        var participants = new java.util.ArrayList<>(
        registrations.stream()
            .map(r -> r.getUser())
            .toList()
        );
        Collections.shuffle(participants);

        var random = new Random();
        int baseTime = 3600; 

        int rank = 1;
        for (var user : participants) {
            ResultEntry result = ResultEntry.builder()
                    .race(race)
                    .user(user)
                    .rankPosition(rank++)
                    .timeSeconds(baseTime + random.nextInt(1800))
                    .build();
            resultRepo.save(result);
        }
    }

    public List<ResultDTO> getResults(Long raceId) {
        var race = raceRepo.findById(raceId)
                .orElseThrow(() -> new IllegalArgumentException("Course introuvable"));
        
        return resultRepo.findByRaceOrderByRankPositionAsc(race).stream()
               .map(r -> new ResultDTO(
                    r.getUser().getFullName(),
                    r.getRankPosition(),
                    r.getTimeSeconds()
                ))
                .toList();
    }

}
