package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskAnalysisService {

    private final List<RiskAnalysisResult> results = new ArrayList<>();

    // Match controller call: runRiskAnalysis(UserPortfolio)
    public RiskAnalysisResult runRiskAnalysis(UserPortfolio portfolio) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setId((long) (results.size() + 1));
        results.add(result);
        return result;
    }

    public List<RiskAnalysisResult> getAnalysisByPortfolio(Long portfolioId) {
        List<RiskAnalysisResult> resultList = new ArrayList<>();
        for (RiskAnalysisResult r : results) {
            if (r.getPortfolio() != null && r.getPortfolio().getId().equals(portfolioId)) {
                resultList.add(r);
            }
        }
        return resultList;
    }
}
