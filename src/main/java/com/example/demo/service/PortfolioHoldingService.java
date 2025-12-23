// package com.example.demo.service;

// import com.example.demo.model.*;
// import com.example.demo.repository.*;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class PortfolioHoldingService {

//     private final PortfolioHoldingRepository holdingRepository;
//     private final UserPortfolioRepository portfolioRepository;
//     private final StockRepository stockRepository;

//     public PortfolioHoldingService(PortfolioHoldingRepository holdingRepository,
//                                    UserPortfolioRepository portfolioRepository,
//                                    StockRepository stockRepository) {
//         this.holdingRepository = holdingRepository;
//         this.portfolioRepository = portfolioRepository;
//         this.stockRepository = stockRepository;
//     }

//     // POST /api/holdings/{portfolioId}/{stockId}
//     public PortfolioHolding addHolding(Long portfolioId, Long stockId, int quantity) {

//         UserPortfolio portfolio = portfolioRepository.findById(portfolioId)
//                 .orElseThrow(() -> new RuntimeException("Portfolio not found"));

//         Stock stock = stockRepository.findById(stockId)
//                 .orElseThrow(() -> new RuntimeException("Stock not found"));

//         PortfolioHolding holding = new PortfolioHolding();
//         holding.setPortfolio(portfolio);
//         holding.setStock(stock);
//         holding.setQuantity(quantity);

//         return holdingRepository.save(holding);
//     }

//     // GET /api/holdings/portfolio/{portfolioId}
//     public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
//         return holdingRepository.findByPortfolioId(portfolioId);
//     }
// }


package com.example.demo.service;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.model.Stock;
import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.PortfolioHoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioHoldingService {

    @Autowired
    private PortfolioHoldingRepository repository;

    public PortfolioHolding addHolding(UserPortfolio portfolio, Stock stock, int quantity) {
        PortfolioHolding holding = new PortfolioHolding();
        holding.setPortfolio(portfolio);
        holding.setStock(stock);
        holding.setQuantity(quantity);
        return repository.save(holding);
    }

    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return repository.findByPortfolioId(portfolioId);
    }
}
