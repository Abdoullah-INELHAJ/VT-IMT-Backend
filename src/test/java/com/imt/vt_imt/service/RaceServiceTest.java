package com.imt.vt_imt.service;

import com.imt.vt_imt.entity.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RaceServiceTest {

    @Autowired
    private RaceService raceService;

    @Test
    void testCreateRace() {
        Race race = raceService.create(
                "Course Test",
                LocalDate.now().plusDays(5),
                "Paris",
                50,
                "https://example.com/parcours"
        );

        assertNotNull(race.getId());
        assertEquals("Course Test", race.getTitle());
    }
}
