

package com.example.demo.service;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }


    public List<Stock> getAllStocks() {
        return stockRepository.findByActiveTrue();
    }

    public Stock updateStock(Long id, Stock updatedStock) {
        return stockRepository.findById(id).map(stock -> {
            stock.setTicker(updatedStock.getTicker());
            stock.setCompanyName(updatedStock.getCompanyName());
            stock.setSector(updatedStock.getSector());
            return stockRepository.save(stock);
        }).orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    public Stock deactivateStock(Long id) {
        return stockRepository.findById(id).map(stock -> {
            stock.setActive(false);
            return stockRepository.save(stock);
        }).orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
