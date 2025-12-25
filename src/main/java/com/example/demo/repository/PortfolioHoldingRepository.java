package com.example.demo.repository;

import com.example.demo.model.PortfolioHolding;
import java.util.List;

public interface PortfolioHoldingRepository {
    List<PortfolioHolding> findByPortfolioId(Long portfolioId);
}
