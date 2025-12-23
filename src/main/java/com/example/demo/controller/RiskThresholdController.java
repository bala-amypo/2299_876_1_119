// package com.example.demo.controller;

// import com.example.demo.model.RiskThreshold;
// import com.example.demo.service.RiskThresholdService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/risk-thresholds")
// public class RiskThresholdController {

//     private final RiskThresholdService thresholdService;

//     public RiskThresholdController(RiskThresholdService thresholdService) {
//         this.thresholdService = thresholdService;
//     }

//     // POST /api/risk-thresholds/{portfolioId}
//     @PostMapping("/{portfolioId}")
//     public RiskThreshold saveOrUpdate(@PathVariable Long portfolioId,
//                                       @RequestBody RiskThreshold threshold) {
//         return thresholdService.saveOrUpdate(portfolioId, threshold);
//     }

//     // GET /api/risk-thresholds/{portfolioId}
//     @GetMapping("/{portfolioId}")
//     public RiskThreshold getThreshold(@PathVariable Long portfolioId) {
//         return thresholdService.getByPortfolio(portfolioId);
//     }
// }




package com.example.demo.controller;

import com.example.demo.model.RiskThreshold;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.RiskThresholdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/risk-thresholds")
public class RiskThresholdController {

    private final RiskThresholdService riskThresholdService;
    private final UserPortfolioRepository userPortfolioRepository;

    public RiskThresholdController(RiskThresholdService riskThresholdService,
                                   UserPortfolioRepository userPortfolioRepository) {
        this.riskThresholdService = riskThresholdService;
        this.userPortfolioRepository = userPortfolioRepository;
    }

    @PostMapping("/{portfolioId}")
    public ResponseEntity<RiskThreshold> createOrUpdateThreshold(
            @PathVariable Long portfolioId,
            @RequestParam double minRisk,
            @RequestParam double maxRisk) {

        Optional<UserPortfolio> portfolioOpt = userPortfolioRepository.findById(portfolioId);
        if (portfolioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RiskThreshold threshold = riskThresholdService.createOrUpdateThreshold(
                portfolioOpt.get(), minRisk, maxRisk);

        return ResponseEntity.ok(threshold);
    }

    @GetMapping("/{portfolioId}")
    public ResponseEntity<RiskThreshold> getThreshold(@PathVariable Long portfolioId) {
        Optional<UserPortfolio> portfolioOpt = userPortfolioRepository.findById(portfolioId);
        if (portfolioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<RiskThreshold> thresholdOpt = riskThresholdService.getThreshold(portfolioOpt.get());
        return thresholdOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
