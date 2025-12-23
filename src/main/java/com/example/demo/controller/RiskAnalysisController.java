// package com.example.demo.controller;

// import com.example.demo.model.RiskAnalysisResult;
// import com.example.demo.service.RiskAnalysisService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/risk-analysis")
// public class RiskAnalysisController {

//     private final RiskAnalysisService service;

//     public RiskAnalysisController(RiskAnalysisService service) {
//         this.service = service;
//     }

//     @PostMapping("/{portfolioId}")
//     public RiskAnalysisResult run(@PathVariable Long portfolioId) {
//         return service.runAnalysis(portfolioId);
//     }

//     @GetMapping("/{portfolioId}")
//     public List<RiskAnalysisResult> get(@PathVariable Long portfolioId) {
//         return service.getResults(portfolioId);
//     }
// }




package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    private double calculatedRisk;

    private String analysisSummary;

    // Getters and Setters
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

    public double getCalculatedRisk() {
        return calculatedRisk;
    }

    public void setCalculatedRisk(double calculatedRisk) {
        this.calculatedRisk = calculatedRisk;
    }

    public String getAnalysisSummary() {
        return analysisSummary;
    }

    public void setAnalysisSummary(String analysisSummary) {
        this.analysisSummary = analysisSummary;
    }
}
