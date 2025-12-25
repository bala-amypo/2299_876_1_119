package com.example.demo.model;

import java.util.List;

public class UserPortfolio {

    private Long id;
    private String name;

    // Optional: list of holdings if needed
    private List<PortfolioHolding> holdings;

    // Constructors
    public UserPortfolio() { }

    public UserPortfolio(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PortfolioHolding> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<PortfolioHolding> holdings) {
        this.holdings = holdings;
    }
}
