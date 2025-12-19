package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "portfolio_id", unique = true)
    private UserPortfolio portfolio;

    private double maxLossPercentage;
    private double maxExposurePercentage;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

    public double getMaxLossPercentage() { return maxLossPercentage; }
    public void setMaxLossPercentage(double maxLossPercentage) {
        this.maxLossPercentage = maxLossPercentage;
    }

    public double getMaxExposurePercentage() { return maxExposurePercentage; }
    public void setMaxExposurePercentage(double maxExposurePercentage) {
        this.maxExposurePercentage = maxExposurePercentage;
    }
}
