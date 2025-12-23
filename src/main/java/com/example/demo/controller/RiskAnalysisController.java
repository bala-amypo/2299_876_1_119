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
