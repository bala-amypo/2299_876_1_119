package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    public boolean login(String username, String password) {
        return true; // mock login always succeeds
    }
}
