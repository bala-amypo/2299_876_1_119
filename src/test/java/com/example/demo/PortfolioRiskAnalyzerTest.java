package com.example.demo;

import com.example.demo.service.PortfolioService;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PortfolioRiskAnalyzerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private RiskAnalysisService riskAnalysisService;

    @Test
    void userServiceTest() {
        // This will pass if your implementation returns "MockUser"
        String user = userService.getUserById(1L);
        assertEquals("MockUser", user);
    }

    @Test
    void portfolioRiskTest() {
        // This will pass if your implementation returns 50
        assertEquals(50, portfolioService.calculateRisk());
    }

    @Test
    void riskAnalysisTest() {
        // This will pass if your implementation returns "Safe"
        assertEquals("Safe", riskAnalysisService.analyze());
    }
}
