package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioHoldingService {

    private final List<PortfolioHolding> holdings = new ArrayList<>();

    // Match controller call: addHolding(UserPortfolio, Stock, int)
    public PortfolioHolding addHolding(UserPortfolio portfolio, Stock stock, int quantity) {
        PortfolioHolding holding = new PortfolioHolding();
        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        holding.setQuantity(quantity);
        holdings.add(holding);
        return holding;
    }

    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        List<PortfolioHolding> result = new ArrayList<>();
        for (PortfolioHolding h : holdings) {
            if (h.getPortfolio() != null && h.getPortfolio().getId().equals(portfolioId)) {
                result.add(h);
            }
        }
        return result;
    }
}
