package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class PortfolioRiskAnalyzer {

    private final UserService userService;

    public PortfolioRiskAnalyzer(UserService userService) {
        this.userService = userService;
    }

    public boolean checkUser(String email) {
        return userService.findByEmail(email).isPresent();
    }
}
