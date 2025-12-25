package com.example.demo.model;

public class RiskAnalysisResult {
    private Long id;
    private UserPortfolio portfolio;
    private int riskScore;
    private String notes;
    private double highestStockPercentage;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

    public int getRiskScore() { return riskScore; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(double highestStockPercentage) { this.highestStockPercentage = highestStockPercentage; }
}
