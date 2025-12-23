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
            .csrf(csrf -> csrf.disable()) // Disable CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/v3/api-docs/**",  // Swagger JSON
                    "/swagger-ui/**",    // Swagger UI
                    "/swagger-ui.html",  // fallback
                    "/auth/**"           // your login/register
                ).permitAll()           // allow public access
                .anyRequest().authenticated() // everything else needs auth
            )
            .formLogin(form -> form.disable())   // Disable default login page
            .httpBasic(httpBasic -> httpBasic.disable()); // Disable browser popup

        return http.build();
    }
}
