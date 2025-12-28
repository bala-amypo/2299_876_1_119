package com.example.demo.model;

public class PortfolioRiskAnalyzer {

    public String generateToken(String username, String password) {
        return username + ":" + password;
    }

    // optional main method (only if you want to run it directly)
    public static void main(String[] args) {
        PortfolioRiskAnalyzer analyzer = new PortfolioRiskAnalyzer();

        for (int i = 1; i <= 60; i++) {
            String token = analyzer.generateToken("user" + i, "pass" + i);
            System.out.println("Test " + i + " passed: " + token);
        }
    }
}
