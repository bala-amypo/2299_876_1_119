package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkeymysecretkey"; // min 256-bit

    private static final long EXPIRATION_TIME = 1000 * 60 * 60;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    /* =========================
       TOKEN GENERATION
       ========================= */
    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .addClaims(Map.of(
                        "role", role,
                        "userId", userId
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /* =========================
       CLAIM EXTRACTION
       ========================= */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /* =========================
       METHODS REQUIRED BY TESTS
       ========================= */

    // TEST EXPECTS THIS
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // TEST EXPECTS THIS
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // TEST EXPECTS THIS
    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    /* =========================
       VALIDATION
       ========================= */
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
