package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_threshold", uniqueConstraints = @UniqueConstraint(columnNames = "threshold_name"))
public class RiskThreshold {

    @Id
    private Long id;

    private String thresholdName;

    private float maxSectorPercentage;

    private float maxSingleStockPercentage;

    private boolean active;

    public RiskThreshold() {}

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getThresholdName() { return thresholdName; }
    public void setThresholdName(String thresholdName) { this.thresholdName = thresholdName; }

    public float getMaxSectorPercentage() { return maxSectorPercentage; }
    public void setMaxSectorPercentage(float maxSectorPercentage) { this.maxSectorPercentage = maxSectorPercentage; }

    public float getMaxSingleStockPercentage() { return maxSingleStockPercentage; }
    public void setMaxSingleStockPercentage(float maxSingleStockPercentage) { this.maxSingleStockPercentage = maxSingleStockPercentage; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
