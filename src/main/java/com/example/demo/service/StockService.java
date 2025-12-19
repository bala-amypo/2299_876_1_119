package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Optional<Stock> findByTicker(String ticker) {
        return stockRepository.findByTicker(ticker);
    }

    public Iterable<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }
}
