package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Override
    public String analyze() {
        return "Safe";
    }

    @Override
    public RiskAnalysisResult runRiskAnalysis(UserPortfolio portfolio) {
        // Return mock result for now
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setRiskScore(50);
        result.setNotes("Mock analysis");
        result.setPortfolio(portfolio);
        return result;
    }

    @Override
    public List<RiskAnalysisResult> getAnalysisByPortfolio(Long portfolioId) {
        // Return a mock list
        return Collections.emptyList();
    }
}
