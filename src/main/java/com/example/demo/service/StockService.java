package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // CREATE
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    // READ ALL  ✅ returns List (important)
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    // READ BY TICKER
    public Optional<Stock> getStockByTicker(String ticker) {
        return stockRepository.findByTicker(ticker);
    }

    // UPDATE
    public Stock updateStock(Long id, Stock updatedStock) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setTicker(updatedStock.getTicker());
                    stock.setCompanyName(updatedStock.getCompanyName());
                    stock.setSector(updatedStock.getSector());
                    stock.setActive(updatedStock.isActive());
                    return stockRepository.save(stock);
                })
                .orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    // DELETE
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
