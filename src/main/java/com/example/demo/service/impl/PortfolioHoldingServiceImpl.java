package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository holdingRepository, 
                                       UserPortfolioRepository portfolioRepository, 
                                       StockRepository stockRepository) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        return holdingRepository.save(holding);
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return holdingRepository.findByPortfolioId(portfolioId);
    }

    @Override
    public void deleteHolding(Long id) {
        holdingRepository.deleteById(id);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Holding not found"));
    }
}