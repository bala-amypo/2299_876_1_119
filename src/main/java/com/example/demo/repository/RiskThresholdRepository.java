package com.example.demo.repository;

import com.example.demo.model.RiskThreshold;

public interface RiskThresholdRepository {
    RiskThreshold findByActiveTrue();
}
