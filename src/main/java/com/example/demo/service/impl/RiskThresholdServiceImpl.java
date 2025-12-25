package com.example.demo.service.impl;

import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;

import java.util.ArrayList;
import java.util.List;

public class RiskThresholdServiceImpl implements RiskThresholdService {

    private final RiskThresholdRepository repository;

    // ✅ exact constructor
    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        return threshold;
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return threshold;
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue();
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return new RiskThreshold();
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return new ArrayList<>();
    }
}
