package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPortfolioService {

    private final List<UserPortfolio> portfolios = new ArrayList<>();

    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        portfolio.setId((long) (portfolios.size() + 1));
        portfolios.add(portfolio);
        return portfolio;
    }

    public UserPortfolio getPortfolioById(Long id) {
        return portfolios.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<UserPortfolio> getPortfoliosByUserId(Long userId) {
        return portfolios; // return all for simplicity
    }

    public Object getStockById(Long id) {
        return null; // dummy
    }
}
