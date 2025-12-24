package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Override
    public String analyze() {
        // Mock analysis
        return "Safe";
    }
}
