package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import java.util.List;

public interface RiskAnalysisService {
    RiskAnalysisResult analyzePortfolio(Long portfoliold);
    RiskAnalysisResult getAnalysisById(Long id);
    List<RiskAnalysisResult> getAnalysesForPortfolio(Long portfoliold);
}