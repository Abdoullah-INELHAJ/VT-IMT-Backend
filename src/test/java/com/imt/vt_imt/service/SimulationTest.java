package com.imt.vt_imt.service;

import com.imt.vt_imt.entity.User;
import com.imt.vt_imt.entity.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimulationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RaceService raceService;

    @Test
    void testSimulateResults() {
        User u1 = userService.createOrGet("alice@test.com", "Alice");
        User u2 = userService.createOrGet("bob@test.com", "Bob");

        Race r = raceService.create("Course Simulation", LocalDate.now().minusDays(1), "Marseille", 10, "https://route");

        raceService.register(r.getId(), u1.getId());
        raceService.register(r.getId(), u2.getId());

        raceService.simulateResults(r.getId());

        var results = raceService.getResults(r.getId());
        assertEquals(2, results.size());
    }
}
