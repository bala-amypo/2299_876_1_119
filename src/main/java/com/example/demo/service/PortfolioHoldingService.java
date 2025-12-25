package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioHoldingService {

    private final List<PortfolioHolding> holdings = new ArrayList<>();

    public PortfolioHolding addHolding(PortfolioHolding holding) {
        holdings.add(holding);
        return holding;
    }

    public List<PortfolioHolding> getHoldings() {
        return holdings;
    }
}
