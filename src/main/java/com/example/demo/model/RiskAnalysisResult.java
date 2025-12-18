package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean isHighRisk;
    private String notes;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

    public Timestamp getAnalysisDate() { return analysisDate; }

    public Double getHighestStockPercentage() { return highestStockPercentage; }
    public void setHighestStockPercentage(Double highestStockPercentage) {
        this.highestStockPercentage = highestStockPercentage;
    }

    public Double getHighestSectorPercentage() { return highestSectorPercentage; }
    public void setHighestSectorPercentage(Double highestSectorPercentage) {
        this.highestSectorPercentage = highestSectorPercentage;
    }

    public Boolean getIsHighRisk() { 
    return isHighRisk; 
    }
    public void setIsHighRisk(Boolean highRisk) { 
    isHighRisk = highRisk; 
    }

    public String getNotes() { 
    return notes; 
    }
    public void setNotes(String notes) {
     this.notes = notes; 
     }

    
    public RiskAnalysisResult() {
    }

    public RiskAnalysisResult(UserPortfolio portfolio, Double highestStockPercentage, Double highestSectorPercentage,Boolean isHighRisk,String notes) {
        this.portfolio = portfolio;
        this.highestStockPercentage = highestStockPercentage;
        this.highestSectorPercentage = highestSectorPercentage;
        this.isHighRisk = isHighRisk;
        this.notes = notes;
        this.analysisDate = new Timestamp(System.currentTimeMillis());
    }
}
