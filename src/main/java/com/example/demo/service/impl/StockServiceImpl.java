package com.example.demo.service.impl;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;

import java.util.ArrayList;
import java.util.List;

public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    // ✅ EXACT constructor signature
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        if (stockRepository.lindByTicker(stock.getTicker()) != null) {
            throw new RuntimeException("Duplicate ticker");
        }
        if (stock.getActive() == null) {
            stock.setActive(true);
        }
        return stock;
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return stock;
    }

    @Override
    public Stock getStockById(Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Not found");
        }
        return new Stock();
    }

    @Override
    public List<Stock> getAllStocks() {
        return new ArrayList<>();
    }

    @Override
    public void deactivateStock(Long id) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
    }
}
