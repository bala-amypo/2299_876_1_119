// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class UserPortfolio {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String portfolioName;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getPortfolioName() { return portfolioName; }
//     public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }
// }
