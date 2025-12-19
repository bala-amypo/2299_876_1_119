package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // READ ALL
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    // READ BY ID
    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    // UPDATE
    public Stock updateStock(Long id, Stock updatedStock) {
        Stock stock = getStockById(id);
        stock.setTicker(updatedStock.getTicker());
        stock.setCompanyName(updatedStock.getCompanyName());
        stock.setSector(updatedStock.getSector());
        stock.setActive(updatedStock.isActive());
        return stockRepository.save(stock);
    }

    // DELETE (hard delete)
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    // DEACTIVATE (soft delete)
    public Stock deactivateStock(Long id) {
        Stock stock = getStockById(id);
        stock.setActive(false);
        return stockRepository.save(stock);
    }
}
