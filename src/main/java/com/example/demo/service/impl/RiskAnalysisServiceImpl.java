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

    // Requirement Step 0.5: Exact constructor order
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
    public RiskAnalysisResult analyzePortfolio(Long portfoliold) {
        // 1. Fetch Portfolio
        UserPortfolio portfolio = userPortfolioRepository.findById(portfoliold)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        // 2. Fetch Holdings and Active Threshold
        List<PortfolioHolding> holdings = portfolioHoldingRepository.findByPortfolioId(portfoliold);
        RiskThreshold threshold = riskThresholdRepository.findByActiveTrue()
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));

        if (holdings.isEmpty()) {
            throw new RuntimeException("Portfolio is empty");
        }

        // 3. Calculate Math
        double totalValue = 0;
        for (PortfolioHolding h : holdings) {
            totalValue += h.getMarketValue().doubleValue();
        }

        Map<String, Double> stockPcts = new HashMap<>();
        Map<String, Double> sectorPcts = new HashMap<>();

        for (PortfolioHolding h : holdings) {
            double pct = (h.getMarketValue().doubleValue() / totalValue) * 100;
            String ticker = h.getStock().getTicker();
            String sector = h.getStock().getSector();

            stockPcts.put(ticker, stockPcts.getOrDefault(ticker, 0.0) + pct);
            sectorPcts.put(sector, sectorPcts.getOrDefault(sector, 0.0) + pct);
        }

        double maxStockPct = Collections.max(stockPcts.values());
        double maxSectorPct = Collections.max(sectorPcts.values());

        // 4. Create Result Object
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(new Timestamp(System.currentTimeMillis()));
        result.setHighestStockPercentage(maxStockPct);
        result.setHighestSectorPercentage(maxSectorPct);

        // 5. Check Risk
        boolean isHighRisk = maxStockPct > threshold.getMaxSingleStockPercentage() || 
                             maxSectorPct > threshold.getMaxSectorPercentage();
        result.setHighRisk(isHighRisk);

        return riskAnalysisResultRepository.save(result);
    }

    @Override
    public RiskAnalysisResult getAnalysisById(Long id) {
        return riskAnalysisResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    // FIX: This is the method the compiler said was missing
    @Override
    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfoliold) {
        return riskAnalysisResultRepository.findByPortfolioId(portfoliold);
    }
}