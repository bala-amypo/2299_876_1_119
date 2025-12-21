package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAnalysisService {

    private final RiskAnalysisResultRepository repository;
    private final UserPortfolioRepository portfolioRepository;

    public RiskAnalysisService(RiskAnalysisResultRepository repository,
                               UserPortfolioRepository portfolioRepository) {
        this.repository = repository;
        this.portfolioRepository = portfolioRepository;
    }

    public RiskAnalysisResult runAnalysis(Long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        double riskScore = Math.random() * 100; // simple logic for demo

        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setRiskScore(riskScore);

        return repository.save(result);
    }

    public List<RiskAnalysisResult> getResults(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
