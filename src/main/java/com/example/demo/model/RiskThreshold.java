// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class RiskThreshold {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "portfolio_id", unique = true)
//     private UserPortfolio portfolio;

//     private double maxLossPercentage;
//     private double maxExposurePercentage;

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public UserPortfolio getPortfolio() { return portfolio; }
//     public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

//     public double getMaxLossPercentage() { return maxLossPercentage; }
//     public void setMaxLossPercentage(double maxLossPercentage) {
//         this.maxLossPercentage = maxLossPercentage;
//     }

//     public double getMaxExposurePercentage() { return maxExposurePercentage; }
//     public void setMaxExposurePercentage(double maxExposurePercentage) {
//         this.maxExposurePercentage = maxExposurePercentage;
//     }
// }





package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    private double maxRisk;       // Maximum allowed risk
    private double minRisk;       // Minimum allowed risk

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

    public double getMaxRisk() { return maxRisk; }
    public void setMaxRisk(double maxRisk) { this.maxRisk = maxRisk; }

    public double getMinRisk() { return minRisk; }
    public void setMinRisk(double minRisk) { this.minRisk = minRisk; }
}
