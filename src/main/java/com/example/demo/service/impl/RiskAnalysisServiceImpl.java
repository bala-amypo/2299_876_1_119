package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    private final RiskAnalysisResultRepository analysisRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;

    // Requirement: Must follow this exact constructor parameter order
    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository analysisRepository,
                                   UserPortfolioRepository portfolioRepository,
                                   PortfolioHoldingRepository holdingRepository,
                                   RiskThresholdRepository thresholdRepository) {
        this.analysisRepository = analysisRepository;
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Not found"));
        
        // Logical aggregation of holdings and threshold comparison goes here...
        
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        // result.setHighRisk(logicValue);
        
        return analysisRepository.save(result);
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return analysisRepository.findByPortfolioId(portfolioId);
    }
}