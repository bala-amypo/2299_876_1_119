package com.example.demo.repository;

import com.example.demo.model.RiskAnalysisResult;
import java.util.List;

public interface RiskAnalysisResultRepository {
    List<RiskAnalysisResult> findByPortfolioId(Long portfolioId);
}
