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




package com.example.demo.controller;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskAnalysisService;
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

    @PostMapping("/{portfolioId}")
    public RiskAnalysisResult runAnalysis(@PathVariable Long portfolioId) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        return service.runRiskAnalysis(portfolio);
    }

    @GetMapping("/{portfolioId}")
    public List<RiskAnalysisResult> getAnalysis(@PathVariable Long portfolioId) {
        return service.getAnalysisByPortfolio(portfolioId);
    }
}
