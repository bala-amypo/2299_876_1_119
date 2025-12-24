package com.example.demo.service.impl;

import com.example.demo.service.RiskAnalysisService;
import org.springframework.stereotype.Service;

@Service
public class RiskAnalysisServiceImpl implements RiskAnalysisService {

    @Override
    public String analyze() {
        return "Safe";
    }
}
