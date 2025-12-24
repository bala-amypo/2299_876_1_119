package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isHighRisk;

    public RiskAnalysisResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getIsHighRisk() { return isHighRisk; }
    public void setIsHighRisk(Boolean highRisk) {
        isHighRisk = highRisk;
    }
}
