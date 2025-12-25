package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAnalysisService {

    private final List<RiskAnalysisResult> results = new ArrayList<>();

    public RiskAnalysisResult analyzePortfolio(Long portfolioId) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setId((long) (results.size() + 1));
        results.add(result);
        return result;
    }

    public List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfolioId) {
        return results;
    }
}
