package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
    name = "user_portfolio",
    uniqueConstraints = @UniqueConstraint(columnNames = {"userid", "portfolioName"})
)
public class UserPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userid;
    private String portfolioName;
    private Boolean active = true;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserid() { return userid; }
    public void setUserid(Long userid) { this.userid = userid; }

    public String getPortfolioName() { return portfolioName; }
    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }

    // ===== DEFAULT CONSTRUCTOR =====
    public UserPortfolio() {
    }

    // ===== PARAMETERIZED CONSTRUCTOR =====
    public UserPortfolio(Long userid, String portfolioName) {
        this.userid = userid;
        this.portfolioName = portfolioName;
    }

    @PrePersist
    public void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
