package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
@Data
@NoArgsConstructor
public class RiskAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private boolean highRisk; // Lombok generates isHighRisk() which matches test file

    public boolean isHighRisk() {
        return highRisk;
    }
}