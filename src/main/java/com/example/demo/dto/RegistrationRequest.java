package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String fullName;
    private String email;
    private String password;
    private String role; // Optional: Defaults to MONITOR if null
}