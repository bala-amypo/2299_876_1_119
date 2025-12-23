// package com.example.demo.repository;

// import com.example.demo.model.Stock;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface StockRepository extends JpaRepository<Stock, Long> {
// }




package com.example.demo.repository;

import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    // Optional: Find all active stocks
    List<Stock> findByActiveTrue();
}
