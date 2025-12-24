package com.example.demo.service.impl;

import com.example.demo.service.PortfolioService;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Override
    public int calculateRisk() {
        return 50; // Mock response for testing
    }
}
