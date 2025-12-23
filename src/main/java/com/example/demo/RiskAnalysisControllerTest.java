package com.example.demo;

import com.example.demo.controller.RiskAnalysisController;
import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RiskAnalysisControllerTest {

    @Mock
    private RiskAnalysisService riskAnalysisService;

    @InjectMocks
    private RiskAnalysisController riskAnalysisController;

    @Test
    void testGetRiskAnalysisByPortfolioId() {
        // Prepare test data
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setId(1L);
        result.setRiskScore(5);
        result.setAnalysisDate(LocalDate.now());

        // Mock service call
        when(riskAnalysisService.getRiskAnalysisByPortfolioId(1L))
                .thenReturn(Collections.singletonList(result));

        // Call controller
        ResponseEntity<List<RiskAnalysisResult>> response =
                riskAnalysisController.getRiskAnalysisByPortfolioId(1L);

        // Assertions
        assertEquals(1, response.getBody().size());
        assertEquals(5, response.getBody().get(0).getRiskScore());
    }
}
