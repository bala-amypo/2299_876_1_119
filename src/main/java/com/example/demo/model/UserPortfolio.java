package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPortfolioService {

    // Dummy method to get a Stock by ID
    public Stock getStockById(long id) {
        Stock stock = new Stock();
        stock.setId(id);           // make sure Stock.java has setId()
        stock.setName("Dummy");    // make sure Stock.java has setName()
        return stock;
    }

    // Dummy method to get all portfolios for a user
    public List<UserPortfolio> getPortfoliosByUser(long userId) {
        List<UserPortfolio> portfolios = new ArrayList<>();
        UserPortfolio portfolio = new UserPortfolio();
        portfolio.setId(1L);               // make sure UserPortfolio.java has setId()
        portfolio.setName("My Portfolio"); // make sure UserPortfolio.java has setName()
        portfolios.add(portfolio);
        return portfolios;
    }

    // Dummy method to get a portfolio by ID
    public UserPortfolio getPortfolio(long portfolioId) {
        UserPortfolio portfolio = new UserPortfolio();
        portfolio.setId(portfolioId);
        portfolio.setName("Sample Portfolio");
        return portfolio;
    }

    // Add more dummy methods as needed by your tests
}
