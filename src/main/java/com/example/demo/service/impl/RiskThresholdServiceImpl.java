package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskThreshold;
import com.example.demo.repository.RiskThresholdRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskThresholdServiceImpl implements RiskThresholdService {
    private final RiskThresholdRepository repository;

    // Constructor Injection (Requirement Step 0.2)
    public RiskThresholdServiceImpl(RiskThresholdRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskThreshold createThreshold(RiskThreshold threshold) {
        if (threshold.getMaxSingleStockPercentage() < 0 || threshold.getMaxSingleStockPercentage() > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        return repository.save(threshold);
    }

    @Override
    public RiskThreshold updateThreshold(Long id, RiskThreshold threshold) {
        RiskThreshold existing = getThresholdById(id);
        existing.setMaxSingleStockPercentage(threshold.getMaxSingleStockPercentage());
        existing.setMaxSectorPercentage(threshold.getMaxSectorPercentage());
        existing.setActive(threshold.getActive());
        return repository.save(existing);
    }

    @Override
    public RiskThreshold getActiveThreshold() {
        return repository.findByActiveTrue()
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public RiskThreshold getThresholdById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<RiskThreshold> getAllThresholds() {
        return repository.findAll();
    }
} // Ensure this closing brace is present