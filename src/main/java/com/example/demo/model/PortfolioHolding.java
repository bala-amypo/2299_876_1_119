// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class PortfolioHolding {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "portfolio_id", nullable = false)
//     private UserPortfolio portfolio;

//     @ManyToOne
//     @JoinColumn(name = "stock_id", nullable = false)
//     private Stock stock;

//     private int quantity;

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public UserPortfolio getPortfolio() { return portfolio; }
//     public void setPortfolio(UserPortfolio portfolio) { this.portfolio = portfolio; }

//     public Stock getStock() { return stock; }
//     public void setStock(Stock stock) { this.stock = stock; }

//     public int getQuantity() { return quantity; }
//     public void setQuantity(int quantity) { this.quantity = quantity; }
// }
