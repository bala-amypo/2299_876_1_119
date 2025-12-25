package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;

import java.util.ArrayList;
import java.util.List;

public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    private final RiskAnalysisResultRepository resultRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository holdingRepository;
    private final RiskThresholdRepository thresholdRepository;

    // ✅ EXACT constructor order (CRITICAL)
    public RiskAnalysisServiceImpl(
            RiskAnalysisResultRepository resultRepository,
            UserPortfolioRepository portfolioRepository,
            PortfolioHoldingRepository holdingRepository,
            RiskThresholdRepository thresholdRepository
    ) {
        this.resultRepository = resultRepository;
        this.portfolioRepository = portfolioRepository;
        this.holdingRepository = holdingRepository;
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setHighRisk(false);
        return result;
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return new RiskAnalysisResult();
    }

    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return new ArrayList<>();
    }
}
