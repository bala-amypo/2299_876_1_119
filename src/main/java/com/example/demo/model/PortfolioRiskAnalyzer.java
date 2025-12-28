package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PortfolioRiskAnalyzerTest {

    @Test
    public void testGenerateToken() {
        PortfolioRiskAnalyzer analyzer = new PortfolioRiskAnalyzer();
        String token = analyzer.generateToken("user", "pass");
        assertEquals("user:pass", token);
    }
}
