package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "portfolio_holding")
public class PortfolioHolding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long portfolioId;

    private Long stockId;

    private float quantity;

    private BigDecimal marketValue;

    private LocalDateTime lastUpdated;

    public PortfolioHolding() {}

    public Long getId() { 
        return id;
         }
    public void setId(Long id) {
     this.id = id; 
     }

    public Long getPortfolioId() {
         return portfolioId; 
         }
    public void setPortfolioId(Long portfolioId) { 
        this.portfolioId = portfolioId;
         }

    public Long getStockId() { 
        return stockId; 
        }
    public void setStockId(Long stockId) { 
        this.stockId = stockId;
         }

    public float getQuantity() { 
        return quantity; 
        }
    public void setQuantity(float quantity) { 
        this.quantity = quantity; 
        }

    public BigDecimal getMarketValue() { 
        return marketValue;
         }
    public void setMarketValue(BigDecimal marketValue) { 
        this.marketValue = marketValue; 
        }

    public LocalDateTime getLastUpdated() {
         return lastUpdated; 
         }
    public void setLastUpdated(LocalDateTime lastUpdated) { 
        this.lastUpdated = lastUpdated; 
        }
}
