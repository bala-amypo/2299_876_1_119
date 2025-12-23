// package com.example.demo.service;

// import com.example.demo.model.Stock;
// import com.example.demo.repository.StockRepository;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class StockService {

//     private final StockRepository stockRepository;

//     public StockService(StockRepository stockRepository) {
//         this.stockRepository = stockRepository;
//     }

//     public Stock createStock(Stock stock) {
//         return stockRepository.save(stock);
//     }

//     public List<Stock> getAllStocks() {
//         return stockRepository.findAll();
//     }

//     public Stock getStockById(Long id) {
//         return stockRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
//     }

//     public Stock updateStock(Long id, Stock updatedStock) {
//         Stock stock = getStockById(id);
//         stock.setTicker(updatedStock.getTicker());
//         stock.setCompanyName(updatedStock.getCompanyName());
//         stock.setSector(updatedStock.getSector());
//         stock.setActive(updatedStock.isActive());
//         return stockRepository.save(stock);
//     }

//     public void deleteStock(Long id) {
//         stockRepository.deleteById(id);
//     }
// }



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

    // Create new stock
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    // Get stock by ID
    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    // Get all active stocks
    public List<Stock> getAllStocks() {
        return stockRepository.findByActiveTrue();
    }

    // Update stock
    public Stock updateStock(Long id, Stock updatedStock) {
        return stockRepository.findById(id).map(stock -> {
            stock.setTicker(updatedStock.getTicker());
            stock.setCompanyName(updatedStock.getCompanyName());
            stock.setSector(updatedStock.getSector());
            return stockRepository.save(stock);
        }).orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    // Deactivate stock (soft delete)
    public Stock deactivateStock(Long id) {
        return stockRepository.findById(id).map(stock -> {
            stock.setActive(false);
            return stockRepository.save(stock);
        }).orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    // Hard delete (optional)
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
