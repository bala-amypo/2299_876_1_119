package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.service.PortfolioHoldingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Portfolio Holding Management")
public class PortfolioHoldingController {
    private final PortfolioHoldingService service;

    public PortfolioHoldingController(PortfolioHoldingService service) {
        this.service = service;
    }

    @PostMapping
    public PortfolioHolding create(@RequestBody PortfolioHolding holding) {
        return service.createHolding(holding);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getByPortfolio(@PathVariable Long portfolioId) {
        return service.getHoldingsByPortfolio(portfolioId);
    }
}