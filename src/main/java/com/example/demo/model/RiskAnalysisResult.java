package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "risk_analysis_result")
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;

    private boolean isHighRisk;

    private String notes;

    private LocalDateTime analysisDate;

    private float highestSectorPercentage;

    private float highestStockPercentage;

    public RiskAnalysisResult() {}

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPortfolioId() { return portfolioId; }
    public void setPortfolioId(Long portfolioId) { this.portfolioId = portfolioId; }

    public boolean isHighRisk() { return isHighRisk; }
    public void setHighRisk(boolean highRisk) { isHighRisk = highRisk; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(LocalDateTime analysisDate) { this.analysisDate = analysisDate; }

    public float getHighestSectorPercentage() { return highestSectorPercentage; }
    public void setHighestSectorPercentage(float highestSectorPercentage) { this.highestSectorPercentage = highestSectorPercentage; }

    public float getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(float highestStockPercentage) { this.highestStockPercentage = highestStockPercentage; }
}

