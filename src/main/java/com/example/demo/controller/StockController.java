package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return (List<Stock>) stockService.getAllStocks();
    }

    @GetMapping("/{ticker}")
    public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {
        Optional<Stock> stock = stockService.findByTicker(ticker);
        return stock.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stockDetails) {
        Optional<Stock> optionalStock = stockService.getAllStocks().stream().filter(s -> s.getId().equals(id)).findFirst();
        if (optionalStock.isEmpty()) return ResponseEntity.notFound().build();

        Stock stock = optionalStock.get();
        stock.setTicker(stockDetails.getTicker());
        stock.setCompanyName(stockDetails.getCompanyName());
        stock.setSector(stockDetails.getSector());
        stock.setActive(stockDetails.isActive());
        stockService.saveStock(stock);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
