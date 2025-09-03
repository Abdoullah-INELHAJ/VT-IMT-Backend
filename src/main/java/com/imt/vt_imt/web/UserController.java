package com.imt.vt_imt.web;
import com.imt.vt_imt.dto.UserDetailDTO;
import com.imt.vt_imt.entity.User;
import com.imt.vt_imt.service.UserService;
import org.springframework.web.bind.annotation.*;

record CreateUserRequest(String email, String fullName) {}

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User create(@RequestBody CreateUserRequest req) {
        return userService.createOrGet(req.email(), req.fullName());
    }

    @GetMapping("/me")
    public UserDetailDTO me(@RequestHeader("X-User-Id") Long userId) {
         return userService.getDetail(userId);
    }
}
