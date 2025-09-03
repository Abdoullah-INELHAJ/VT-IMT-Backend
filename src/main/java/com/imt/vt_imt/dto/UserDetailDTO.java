package com.imt.vt_imt.dto;

import java.util.List;

public record UserDetailDTO(
        Long id,
        String fullName,
        String email,
        List<RegistrationDTO> registrations
) {}
