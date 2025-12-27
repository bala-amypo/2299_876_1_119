package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.*;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    private final RiskAnalysisResultRepository riskAnalysisResultRepository;
    private final UserPortfolioRepository userPortfolioRepository;
    private final PortfolioHoldingRepository portfolioHoldingRepository;
    private final RiskThresholdRepository riskThresholdRepository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository riskAnalysisResultRepository,
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
        if (totalValue == 0) throw new RuntimeException("Portfolio is empty");

        Map<String, Double> stockWeights = new HashMap<>();
        Map<String, Double> sectorWeights = new HashMap<>();

        for (PortfolioHolding h : holdings) {
            double weight = (h.getMarketValue().doubleValue() / totalValue) * 100;
            stockWeights.merge(h.getStock().getTicker(), weight, Double::sum);
            sectorWeights.merge(h.getStock().getSector(), weight, Double::sum);
        }

        double maxStock = Collections.max(stockWeights.values());
        double maxSector = Collections.max(sectorWeights.values());

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        result.setHighestStockPercentage(maxStock);
        result.setHighestSectorPercentage(maxSector);
        
        boolean highRisk = maxStock > threshold.getMaxSingleStockPercentage() || 
                          maxSector > threshold.getMaxSectorPercentage();
        result.setIsHighRisk(highRisk);

        return riskAnalysisResultRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return riskAnalysisResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return riskAnalysisResultRepository.findByPortfolioId(portfolioId);
    }
}