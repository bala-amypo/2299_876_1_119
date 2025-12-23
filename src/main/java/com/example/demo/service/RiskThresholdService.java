// package com.example.demo.service;

// import com.example.demo.model.*;
// import com.example.demo.repository.*;
// import org.springframework.stereotype.Service;

// @Service
// public class RiskThresholdService {

//     private final RiskThresholdRepository thresholdRepository;
//     private final UserPortfolioRepository portfolioRepository;

//     public RiskThresholdService(RiskThresholdRepository thresholdRepository,
//                                 UserPortfolioRepository portfolioRepository) {
//         this.thresholdRepository = thresholdRepository;
//         this.portfolioRepository = portfolioRepository;
//     }

//     // POST /api/risk-thresholds/{portfolioId}
//     public RiskThreshold saveOrUpdate(Long portfolioId, RiskThreshold threshold) {

//         UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
//                 .orElseThrow(() -> new RuntimeException("Portfolio not found"));

//         RiskThreshold existing = thresholdRepository.findByPortfolioId(portfolioId)
//                 .orElse(null);

//         if (existing != null) {
//             existing.setMaxLossPercentage(threshold.getMaxLossPercentage());
//             existing.setMaxExposurePercentage(threshold.getMaxExposurePercentage());
//             return thresholdRepository.save(existing);
//         }

//         threshold.setPortfolio(portfolio);
//         return thresholdRepository.save(threshold);
//     }

//     // GET /api/risk-thresholds/{portfolioId}
//     public RiskThreshold getByPortfolio(Long portfolioId) {
//         return thresholdRepository.findByPortfolioId(portfolioId)
//                 .orElseThrow(() -> new RuntimeException("Risk threshold not found"));
//     }
// }



package com.example.demo.service;

import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.RiskThresholdRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiskThresholdService {

    private final RiskThresholdRepository riskThresholdRepository;

    public RiskThresholdService(RiskThresholdRepository riskThresholdRepository) {
        this.riskThresholdRepository = riskThresholdRepository;
    }

    public RiskThreshold createOrUpdateThreshold(UserPortfolio portfolio, double minRisk, double maxRisk) {
        Optional<RiskThreshold> existing = riskThresholdRepository.findByPortfolio(portfolio);

        RiskThreshold threshold = existing.orElse(new RiskThreshold());
        threshold.setPortfolio(portfolio);
        threshold.setMinRisk(minRisk);
        threshold.setMaxRisk(maxRisk);

        return riskThresholdRepository.save(threshold);
    }

    public Optional<RiskThreshold> getThreshold(UserPortfolio portfolio) {
        return riskThresholdRepository.findByPortfolio(portfolio);
    }
}
