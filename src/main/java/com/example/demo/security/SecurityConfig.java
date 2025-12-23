package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/v3/api-docs/**",     // Swagger JSON
                    "/swagger-ui/**",       // Swagger UI
                    "/swagger-ui.html",     // Swagger fallback
                    "/auth/**"              // Allow login/register
                ).permitAll()
                .anyRequest().authenticated() // All other endpoints require authentication
            )
            .httpBasic(); // or use .formLogin() if you want form login
        return http.build();
    }
}
