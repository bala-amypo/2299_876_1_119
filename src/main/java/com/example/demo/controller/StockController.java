// package com.example.demo.controller;

// import com.example.demo.model.Stock;
// import com.example.demo.service.StockService;

// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/stocks")
// public class StockController {

//     private final StockService stockService;

//     public StockController(StockService stockService) {
//         this.stockService = stockService;
//     }

//     @PostMapping
//     public Stock createStock(@RequestBody Stock stock) {
//         return stockService.createStock(stock);
//     }

//     @PutMapping("/{id}")
//     public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
//         return stockService.updateStock(id, stock);
//     }

//     @GetMapping("/{id}")
//     public Stock getStockById(@PathVariable Long id) {
//         return stockService.getStockById(id);
//     }

//     @GetMapping
//     public List<Stock> getAllStocks() {
//         return stockService.getAllStocks();
//     }

//     @DeleteMapping("/{id}")
//     public void deleteStock(@PathVariable Long id) {
//         stockService.deleteStock(id);
//     }
// }




package com.example.demo.controller;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // Create stock
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    // Get stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStock(@PathVariable Long id) {
        return stockService.getStockById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all stocks
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    // Update stock
    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return stockService.updateStock(id, stock);
    }

    // Deactivate stock
    @PatchMapping("/{id}/deactivate")
    public Stock deactivateStock(@PathVariable Long id) {
        return stockService.deactivateStock(id);
    }

    // Hard delete (optional)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();
    }
}
