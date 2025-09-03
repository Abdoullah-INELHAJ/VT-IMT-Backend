package com.imt.vt_imt.dto;

import java.time.LocalDate;

public record RegistrationDTO(
        Long id,
        Long raceId,
        String raceTitle,
        LocalDate raceDate,
        String raceLocation
) {}
