package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.PortfolioHoldingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {
    private final PortfolioHoldingRepository holdingRepo;
    private final UserPortfolioRepository portfolioRepo;
    private final StockRepository stockRepo;

    public PortfolioHoldingServiceImpl(PortfolioHoldingRepository holdingRepo, 
                                       UserPortfolioRepository portfolioRepo, 
                                       StockRepository stockRepo) {
        this.holdingRepo = holdingRepo;
        this.portfolioRepo = portfolioRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        return holdingRepo.save(holding);
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        PortfolioHolding existing = getHoldingById(id);
        if (holding.getQuantity() <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        existing.setQuantity(holding.getQuantity());
        existing.setMarketValue(holding.getMarketValue());
        return holdingRepo.save(existing);
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        return holdingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfoliold) {
        return holdingRepo.findByPortfolioId(portfoliold);
    }

    // FIX: Added the missing deleteHolding method
    @Override
    public void deleteHolding(Long id) {
        if (!holdingRepo.existsById(id)) {
            throw new ResourceNotFoundException("Not found");
        }
        holdingRepo.deleteById(id);
    }
}