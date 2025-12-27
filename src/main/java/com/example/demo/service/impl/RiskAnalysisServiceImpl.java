package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.*;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    private final RiskAnalysisResultRepository riskAnalysisResultRepository;
    private final UserPortfolioRepository userPortfolioRepository;
    private final PortfolioHoldingRepository portfolioHoldingRepository;
    private final RiskThresholdRepository riskThresholdRepository;

    // EXACT CONSTRUCTOR ORDER REQUIRED
    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository riskAnalysisResultRepository,
            UserPortfolioRepository userPortfolioRepository,
            PortfolioHoldingRepository portfolioHoldingRepository,
            RiskThresholdRepository riskThresholdRepository) {
        this.riskAnalysisResultRepository = riskAnalysisResultRepository;
        this.userPortfolioRepository = userPortfolioRepository;
        this.portfolioHoldingRepository = portfolioHoldingRepository;
        this.riskThresholdRepository = riskThresholdRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = userPortfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        
        List<PortfolioHolding> holdings = portfolioHoldingRepository.findByPortfolioId(portfolioId);
        RiskThreshold threshold = riskThresholdRepository.findByActiveTrue()
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        double totalValue = holdings.stream().mapToDouble(h -> h.getMarketValue().doubleValue()).sum();
        
        double maxStockPct = 0;
        Map<String, Double> sectorWeights = new HashMap<>();

        for (PortfolioHolding h : holdings) {
            double weight = (h.getMarketValue().doubleValue() / totalValue) * 100;
            maxStockPct = Math.max(maxStockPct, weight);
            sectorWeights.merge(h.getStock().getSector(), weight, Double::sum);
        }

        double maxSectorPct = sectorWeights.values().stream().mapToDouble(v -> v).max().orElse(0.0);

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        result.setHighestStockPercentage(maxStockPct);
        result.setHighestSectorPercentage(maxSectorPct);
        
        boolean highRisk = maxStockPct > threshold.getMaxSingleStockPercentage() || 
                          maxSectorPct > threshold.getMaxSectorPercentage();
        result.setIsHighRisk(highRisk);

        return riskAnalysisResultRepository.save(result);
    }
    
    // ... implement other methods
}