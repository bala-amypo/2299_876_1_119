package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService thresholdService;

    public RiskThresholdController(RiskThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    // POST /api/risk-thresholds/{portfolioId}
    @PostMapping("/{portfolioId}")
    public RiskThreshold saveOrUpdate(@PathVariable Long portfolioId,
                                      @RequestBody RiskThreshold threshold) {
        return thresholdService.saveOrUpdate(portfolioId, threshold);
    }

    // GET /api/risk-thresholds/{portfolioId}
    @GetMapping("/{portfolioId}")
    public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
        return thresholdService.getByPortfolio(portfolioId);
    }
}
