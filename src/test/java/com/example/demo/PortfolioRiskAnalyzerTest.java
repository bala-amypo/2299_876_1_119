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
        assertEquals("MockUser", userService.getUserById(1L));
    }

    @Test
    void portfolioRiskTest() {
        assertEquals(50, portfolioService.calculateRisk());
    }

    @Test
    void riskAnalysisTest() {
        assertEquals("Safe", riskAnalysisService.analyze());
    }
}
