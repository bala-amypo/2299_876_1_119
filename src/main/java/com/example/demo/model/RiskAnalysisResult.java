package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_result")
public class RiskAnalysisResult {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;

    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean isHighRisk;
    private String notes;

    @PrePersist
    protected void onCreate() {
        analysisDate = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { 
        return id; 
        }
    public void setId(Long id) { 
        this.id = id;
         }

    public UserPortfolio getPortfolio() {
         return portfolio;
          }
    public void setPortfolio(UserPortfolio portfolio) { 
        this.portfolio = portfolio; 
        }

    public Timestamp getAnalysisDate() { 
        return analysisDate; 
        }
    public void setAnalysisDate(Timestamp analysisDate) {
         this.analysisDate = analysisDate; 
         }

    public Double getHighestStockPercentage() { 
        return highestStockPercentage; 
        }
    public void setHighestStockPercentage(Double highestStockPercentage) { 
        this.highestStockPercentage = highestStockPercentage; 
        }

    public Double getHighestSectorPercentage() { 
        return highestSectorPercentage; 
        }
    public void setHighestSectorPercentage(Double highestSectorPercentage) {
         this.highestSectorPercentage = highestSectorPercentage; 
         }

    public Boolean getIsHighRisk() { 
        return isHighRisk; 
        }
    public void setIsHighRisk(Boolean isHighRisk) { 
        this.isHighRisk = isHighRisk; 
        }

    public String getNotes() { 
        return notes;
         }
    public void setNotes(String notes) { 
        this.notes = notes; 
        }
}
