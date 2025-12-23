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
import java.time.LocalDate;

@Entity
public class RiskAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private UserPortfolio portfolio;

    private LocalDate analysisDate;
    private int riskScore;
    private String notes;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserPortfolio getPortfolio() { return portfolio; }
    public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

    public LocalDate getAnalysisDate() { return analysisDate; }
    public void setAnalysisDate(LocalDate analysisDate) { this.analysisDate = analysisDate; }

    public int getRiskScore() { return riskScore; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}




package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.service.RiskAnalysisService;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-analysis")
public class RiskAnalysisController {

    @Autowired
    private RiskAnalysisService service;

    @Autowired
    private UserPortfolioRepository portfolioRepository;

    // Run risk analysis for a portfolio
    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult runAnalysis(@PathVariable Long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        return service.runRiskAnalysis(portfolio);
    }

    // Get all analysis results for a portfolio
    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalysis(@PathVariable Long portfolioId) {
        return service.getAnalysisByPortfolio(portfolioId);
    }
}
