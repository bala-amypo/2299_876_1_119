package com.example.demo.service.impl;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.repository.RiskAnalysisResultRepository;
import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {
    private final RiskAnalysisResultRepository analysisRepository;

    public RiskAnalysisServiceImpl(RiskAnalysisResultRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Override
    public Optional<RiskAnalysisResult> getAnalysisById(Long id) {
        return analysisRepository.findById(id);
    }
    
    // ... keep your other existing methods like performAnalysis here
}