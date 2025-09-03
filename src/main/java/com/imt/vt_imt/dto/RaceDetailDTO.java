package com.imt.vt_imt.dto;

import java.time.LocalDate;
import java.util.List;

public record RaceDetailDTO(
        Long id,
        String title,
        LocalDate date,
        String location,
        Integer capacity,
        String routeUrl,
        List<String> participants
) {}
