// package com.example.demo.service;

// import com.example.demo.model.RiskAnalysisResult;
// import com.example.demo.model.UserPortfolio;
// import com.example.demo.repository.RiskAnalysisResultRepository;
// import com.example.demo.repository.UserPortfolioRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class RiskAnalysisService {

//     private final RiskAnalysisResultRepository repository;
//     private final UserPortfolioRepository portfolioRepository;

//     public RiskAnalysisService(RiskAnalysisResultRepository repository,
//                                UserPortfolioRepository portfolioRepository) {
//         this.repository = repository;
//         this.portfolioRepository = portfolioRepository;
//     }

//     public RiskAnalysisResult runAnalysis(Long portfolioId) {
//         UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
//                 .orElseThrow(() -> new RuntimeException("Portfolio not found"));

//         double riskScore = Math.random() * 100; // simple logic for demo

//         RiskAnalysisResult result = new RiskAnalysisResult();
//         result.setPortfolio(portfolio);
//         result.setRiskScore(riskScore);

//         return repository.save(result);
//     }

//     public List<RiskAnalysisResult> getResults(Long portfolioId) {
//         return repository.findByPortfolioId(portfolioId);
//     }
// }





package com.example.demo.service;

import com.example.demo.model.RiskAnalysisResult;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskAnalysisResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RiskAnalysisService {

    @Autowired
    private RiskAnalysisResultRepository repository;

    public RiskAnalysisResult runRiskAnalysis(UserPortfolio portfolio) {
        RiskAnalysisResult result = new RiskAnalysisResult();
        result.setPortfolio(portfolio);
        result.setAnalysisDate(LocalDate.now());
        result.setRiskScore(50); // Example calculation
        result.setNotes("Analysis complete");
        return repository.save(result);
    }

    public List<RiskAnalysisResult> getAnalysisByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
