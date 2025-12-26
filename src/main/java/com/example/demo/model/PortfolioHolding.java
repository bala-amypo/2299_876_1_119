package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "portfolio_holdings")
@Data
@NoArgsConstructor
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserPortfolio portfolio;

    @ManyToOne
    private Stock stock;

    private Double quantity;

    private BigDecimal marketValue;

    private Timestamp lastUpdated;

    @PreUpdate
    @PrePersist
    protected void onUpdate() {
        lastUpdated = new Timestamp(System.currentTimeMillis());
    }
}