package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import java.util.List;

public interface RiskAnalysisService {
    String analyze();
    RiskAnalysisResult runRiskAnalysis(UserPortfolio portfolio);
    List<RiskAnalysisResult> getAnalysisByPortfolio(Long portfolioId);
}
