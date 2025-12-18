package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio_holding")
public class PortfolioHolding {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private UserPortfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private BigDecimal marketValue;

    private Timestamp lastUpdated;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { 
    return id; 
    }
    public void setId(Long id) { 
    this.id = id; 
    }

    public UserPortfolio getPortfolio() { 
        return portfolio; 
        }
    public void setPortfolio(UserPortfolio portfolio) { 
        this.portfolio = portfolio; 
        }

    public Stock getStock() {
         return stock; 
         }
    public void setStock(Stock stock) { 
        this.stock = stock; 
        }

    public Double getQuantity() { 
    return quantity; 
        }
    public void setQuantity(Double quantity) { 
        this.quantity = quantity; 
        }

    public BigDecimal getMarketValue() { 
        return marketValue; 
        }
    public void setMarketValue(BigDecimal marketValue) { 
        this.marketValue = marketValue; 
        }

    public Timestamp getLastUpdated() { 
        return lastUpdated; 
        }
    public void setLastUpdated(Timestamp lastUpdated) {
         this.lastUpdated = lastUpdated; 
        }
}
