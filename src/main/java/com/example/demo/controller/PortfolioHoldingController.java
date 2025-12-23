// package com.example.demo.controller;

// import com.example.demo.model.PortfolioHolding;
// import com.example.demo.service.PortfolioHoldingService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/holdings")
// public class PortfolioHoldingController {

//     private final PortfolioHoldingService holdingService;

//     public PortfolioHoldingController(PortfolioHoldingService holdingService) {
//         this.holdingService = holdingService;
//     }

//     // POST /api/holdings/{portfolioId}/{stockId}
//     @PostMapping("/{portfolioId}/{stockId}")
//     public PortfolioHolding addHolding(@PathVariable Long portfolioId,
//                                        @PathVariable Long stockId,
//                                        @RequestParam int quantity) {
//         return holdingService.addHolding(portfolioId, stockId, quantity);
//     }

//     // GET /api/holdings/portfolio/{portfolioId}
//     @GetMapping("/portfolio/{portfolioId}")
//     public List<PortfolioHolding> getHoldings(@PathVariable Long portfolioId) {
//         return holdingService.getHoldingsByPortfolio(portfolioId);
//     }
// }



package com.example.demo.controller;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class PortfolioHoldingController {

    @Autowired
    private PortfolioHoldingService service;

    @Autowired
    private UserPortfolioRepository portfolioRepository;

    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/{portfolioId}/{stockId}")
    public PortfolioHolding addHolding(
            @PathVariable Long portfolioId,
            @PathVariable Long stockId,
            @RequestParam int quantity
    ) {
        UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
        return service.addHolding(portfolio, stock, quantity);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioHolding> getHoldings(@PathVariable Long portfolioId) {
        return service.getHoldingsByPortfolio(portfolioId);
    }
}
