package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.service.RiskAnalysisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
@Tag(name = "Risk Analysis Results")
public class RiskAnalysisController {
    private final RiskAnalysisService service;

    public RiskAnalysisController(RiskAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze/{portfolioId}")
    public RiskAnalysisResult analyze(@PathVariable Long portfolioId) {
        return service.analyzePortfolio(portfolioId);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<RiskAnalysisResult> getHistory(@PathVariable Long portfolioId) {
        return service.getAnalysesForPortfolio(portfolioId);
    }
}