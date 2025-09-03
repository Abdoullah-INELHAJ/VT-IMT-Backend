package com.imt.vt_imt.service;

import com.imt.vt_imt.entity.User;
import com.imt.vt_imt.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testCreateOrGet_shouldCreateUser() {
        User u = userService.createOrGet("test@example.com", "Test User");

        assertNotNull(u.getId());
        assertEquals("test@example.com", u.getEmail());
        assertEquals("Test User", u.getFullName());
    }

    @Test
    void testCreateOrGet_shouldReturnExistingUser() {
        User u1 = userService.createOrGet("same@example.com", "First");
        User u2 = userService.createOrGet("same@example.com", "Second");

        assertEquals(u1.getId(), u2.getId()); 
    }
}
