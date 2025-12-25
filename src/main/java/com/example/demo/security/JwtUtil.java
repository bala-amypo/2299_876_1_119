package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "dummy-token-for-" + email;
    }

    public boolean validateToken(String token) {
        return true; // always valid for dummy
    }

    public String extractEmail(String token) {
        return token.replace("dummy-token-for-", "");
    }

    public String extractRole(String token) {
        return "USER";
    }

    public Long extractUserId(String token) {
        return 1L;
    }
}
