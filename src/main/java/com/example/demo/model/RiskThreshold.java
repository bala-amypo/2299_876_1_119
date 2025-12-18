package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_threshold", uniqueConstraints = @UniqueConstraint(columnNames = "thresholdName"))
public class RiskThreshold {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String thresholdName;

    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;

    @Column(nullable = false)
    private Boolean active = true;

    // Getters and Setters
    public Long getId() { 
        return id; 
        }
    public void setId(Long id) {
         this.id = id; 
         }

    public String getThresholdName() { 
        return thresholdName; 
        }
    public void setThresholdName(String thresholdName) {
         this.thresholdName = thresholdName; 
         }

    public Double getMaxSingleStockPercentage() { 
        return maxSingleStockPercentage; 
        }
    public void setMaxSingleStockPercentage(Double maxSingleStockPercentage) { 
        this.maxSingleStockPercentage = maxSingleStockPercentage; 
        }

    public Double getMaxSectorPercentage() { 
        return maxSectorPercentage; 
        }
    public void setMaxSectorPercentage(Double maxSectorPercentage) {
         this.maxSectorPercentage = maxSectorPercentage; 
         }

    public Boolean getActive() {
         return active; 
         }
    public void setActive(Boolean active) { 
        this.active = active; 
        }
}
