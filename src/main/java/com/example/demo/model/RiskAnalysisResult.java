// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class RiskAnalysisResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "portfolio_id", nullable = false)
//     private UserPortfolio portfolio;

//     private double riskScore;
//     private LocalDateTime analysisDate = LocalDateTime.now();

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public UserPortfolio getPortfolio() { return portfolio; }
//     public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

//     public double getRiskScore() { return riskScore; }
//     public void setRiskScore(double riskScore) { this.riskScore = riskScore; }

//     public LocalDateTime getAnalysisDate() { return analysisDate; }
//     public void setAnalysisDate(LocalDateTime analysisDate) { this.analysisDate = analysisDate; }
// }
