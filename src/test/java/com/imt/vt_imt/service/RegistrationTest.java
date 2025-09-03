package com.imt.vt_imt.service;

import com.imt.vt_imt.entity.User;
import com.imt.vt_imt.entity.Race;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RaceService raceService;

    @Test
    void testRegisterUserToRace() {
        User u = userService.createOrGet("bob@example.com", "Bob Dupont");
        Race r = raceService.create("Course d'inscription", LocalDate.now().plusDays(2), "Lyon", 30, "https://route");

        raceService.register(r.getId(), u.getId());

        var detail = raceService.detail(r.getId());
        assertTrue(detail.participants().contains("Bob Dupont"));
    }
}
