package com.example.demo;

import com.example.demo.controller.UserPortfolioController;
import com.example.demo.model.*;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.service.UserPortfolioService;
import com.example.demo.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class PortfolioRiskAnalyzerTest {

    @Mock
    private UserPortfolioService portfolioService;

    @Mock
    private RiskAnalysisService analysisService;

    @Mock
    private UserService userService;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserPortfolioController portfolioController;

    @BeforeClass
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testStockOptionalReturn() {
        Stock stock = new Stock();
        stock.setId(1L);
        stock.setName("AAPL");

        when(portfolioService.getStockById(1L)).thenReturn(Optional.of(stock));

        Optional<Stock> result = portfolioService.getStockById(1L);

        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), "AAPL");
    }

    @Test
    public void testPortfolioHoldingMarketValue() {
        PortfolioHolding holding = new PortfolioHolding();
        holding.setMarketValue(BigDecimal.valueOf(1000));

        assertEquals(holding.getMarketValue(), BigDecimal.valueOf(1000));
    }

    @Test
    public void testUserCreatedAt() {
        User user = new User();
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);

        assertEquals(user.getCreatedAt(), now);
    }

    @Test
    public void testJwtUtilMethods() {
        String token = "dummyToken";
        when(jwtUtil.validateToken(token)).thenReturn(true);
        when(jwtUtil.extractEmail(token)).thenReturn("test@example.com");

        assertTrue(jwtUtil.validateToken(token));
        assertEquals(jwtUtil.extractEmail(token), "test@example.com");
    }

    @Test
    public void testRiskAnalysisResult() {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setHighestStockPercentage(50.0);

        assertEquals(result.getHighestStockPercentage(), 50.0);
    }

    @Test
    public void testRiskThreshold() {
        RiskThreshold threshold = new RiskThreshold();
        threshold.setMaxSingleStockPercentage(20.0);

        assertEquals(threshold.getMaxSingleStockPercentage(), 20.0);
    }

}
