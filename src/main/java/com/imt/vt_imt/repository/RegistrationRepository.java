package com.imt.vt_imt.repository;

import com.imt.vt_imt.entity.Registration;
import com.imt.vt_imt.entity.Race;
import com.imt.vt_imt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByRace(Race race);
    Optional<Registration> findByRaceAndUser(Race race, User user);

    List<Registration> findByUserId(Long userId);

}
