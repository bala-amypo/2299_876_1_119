package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String portfolioName;

    public UserPortfolio() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
}
