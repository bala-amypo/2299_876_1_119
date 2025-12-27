package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_analysis_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;
    private Timestamp analysisDate;
    private Double highestStockPercentage;
    private Double highestSectorPercentage;
    private Boolean isHighRisk;
    private String notes;
}