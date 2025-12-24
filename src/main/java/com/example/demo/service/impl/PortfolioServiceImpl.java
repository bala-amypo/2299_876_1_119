package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Override
    public int calculateRisk() {
        // Mock risk value
        return 50;
    }
}
