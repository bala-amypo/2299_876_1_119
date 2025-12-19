// AuthController.java
package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        AuthResponse response = new AuthResponse();
        response.setUserId(user.getId());
        response.setUsername(user.getUsername());
        response.setToken("dummy-token"); // replace with JWT if needed

        return response;
    }

    // REGISTER
    @PostMapping("/register")
    public AuthResponse register(@RequestBody LoginRequest request) {
        var user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        AuthResponse response = new AuthResponse();
        response.setUserId(user.getId());
        response.setUsername(user.getUsername());
        response.setToken("dummy-token");
        return response;
    }
}
