package com.example.demo.model;

public class RiskThreshold {
    private Long id;
    private UserPortfolio portfolio;
    private double minRisk;
    private double maxRisk;
    private double maxSingleStockPercentage;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

    public double getMinRisk() { return minRisk; }
    public void setMinRisk(double minRisk) { this.minRisk = minRisk; }

    public double getMaxRisk() { return maxRisk; }
    public void setMaxRisk(double maxRisk) { this.maxRisk = maxRisk; }

    public double getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public void setMaxSingleStockPercentage(double maxSingleStockPercentage) { this.maxSingleStockPercentage = maxSingleStockPercentage; }
}
