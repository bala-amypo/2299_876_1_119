package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.service.RiskThresholdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-thresholds")
@Tag(name = "Risk Threshold Management")
public class RiskThresholdController {
    private final RiskThresholdService service;

    public RiskThresholdController(RiskThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public RiskThreshold create(@RequestBody RiskThreshold threshold) {
        return service.createThreshold(threshold);
    }

    @GetMapping("/active")
    public RiskThreshold getActive() {
        return service.getActiveThreshold();
    }
}