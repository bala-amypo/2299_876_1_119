package com.example.demo.service;

import com.example.demo.model.Stock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private final List<Stock> stocks = new ArrayList<>();

    public Stock createStock(Stock stock) {
        stock.setId((long) (stocks.size() + 1));
        stocks.add(stock);
        return stock;
    }

    public List<Stock> getAllStocks() {
        return stocks;
    }

    public Stock getStockById(Long id) {
        return stocks.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
