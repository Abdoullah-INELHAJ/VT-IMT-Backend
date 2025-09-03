package com.imt.vt_imt.service;

import com.imt.vt_imt.entity.User;
import com.imt.vt_imt.dto.UserDetailDTO;
import com.imt.vt_imt.dto.RegistrationDTO;
import com.imt.vt_imt.repository.UserRepository;
import com.imt.vt_imt.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final RegistrationRepository registrationRepo;

    public UserService(UserRepository userRepo, RegistrationRepository registrationRepo) {
        this.userRepo = userRepo;
        this.registrationRepo = registrationRepo;
    }

    public User createOrGet(String email, String fullName) {
        return userRepo.findByEmail(email)
                .orElseGet(() -> userRepo.save(
                        User.builder()
                                .email(email)
                                .fullName(fullName)
                                .createdAt(LocalDateTime.now())
                                .build()
                ));
    }

    public User getById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDetailDTO getDetail(Long userId) {
        User user = getById(userId);

        List<RegistrationDTO> registrations = registrationRepo.findByUserId(userId)
                .stream()
                .map(r -> new RegistrationDTO(
                        r.getId(),
                        r.getRace().getId(), 
                        r.getRace().getTitle(),
                        r.getRace().getDate(),
                        r.getRace().getLocation()
                ))
                .toList();

        return new UserDetailDTO(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                registrations
        );
    }
}
