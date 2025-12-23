package com.example.demo;

import com.example.demo.controller.RiskAnalysisController;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RiskAnalysisControllerTest {

    @Mock
    private RiskAnalysisService service;

    @Mock
    private UserPortfolioRepository portfolioRepository;

    @InjectMocks
    private RiskAnalysisController controller;

    @Test
    void testGetAnalysis() {
        Long portfolioId = 1L;

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setRiskScore(5);

        when(service.getAnalysisByPortfolio(portfolioId))
                .thenReturn(List.of(result));

        List<RiskAnalysisResult> response =
                controller.getAnalysis(portfolioId);

        assertEquals(1, response.size());
        assertEquals(5, response.get(0).getRiskScore());
    }
}
