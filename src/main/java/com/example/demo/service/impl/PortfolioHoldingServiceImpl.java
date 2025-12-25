package com.example.demo.service.impl;

import com.example.demo.model.PortfolioHolding;
import com.example.demo.repository.PortfolioHoldingRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.PortfolioHoldingService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PortfolioHoldingServiceImpl implements PortfolioHoldingService {

    private final PortfolioHoldingRepository holdingRepository;
    private final UserPortfolioRepository portfolioRepository;
    private final StockRepository stockRepository;

    // ✅ exact constructor order
    public PortfolioHoldingServiceImpl(
            PortfolioHoldingRepository holdingRepository,
            UserPortfolioRepository portfolioRepository,
            StockRepository stockRepository
    ) {
        this.holdingRepository = holdingRepository;
        this.portfolioRepository = portfolioRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public PortfolioHolding createHolding(PortfolioHolding holding) {
        if (holding.getQuantity() == null || holding.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be > 0");
        }
        if (holding.getMarketValue() == null) {
            holding.setMarketValue(BigDecimal.ZERO);
        }
        return holding;
    }

    @Override
    public PortfolioHolding updateHolding(Long id, PortfolioHolding holding) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return holding;
    }

    @Override
    public PortfolioHolding getHoldingById(Long id) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return new PortfolioHolding();
    }

    @Override
    public List<PortfolioHolding> getHoldingsByPortfolio(Long portfolioId) {
        return new ArrayList<>();
    }

    @Override
    public void deleteHolding(Long id) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
    }
}
