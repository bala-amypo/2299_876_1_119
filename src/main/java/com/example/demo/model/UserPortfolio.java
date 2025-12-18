package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_portfolio", uniqueConstraints = @UniqueConstraint(columnNames = {"userid", "portfolioName"}))
public class UserPortfolio {

    @Id
    private Long id;

    private Long userid;

    @Column(nullable = false)
    private String portfolioName;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Column(nullable = false)
    private Boolean active = true;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { 
        return id; 
        }
    public void setId(Long id) { 
    this.id = id; 
    }

    public Long getUserid() {
         return userid; 
         }
    public void setUserid(Long userid) { 
        this.userid = userid; 
        }

    public String getPortfolioName() { 
        return portfolioName; 
        }
    public void setPortfolioName(String portfolioName) { 
        this.portfolioName = portfolioName; 
        }

    public Timestamp getCreatedAt() { 
        return createdAt; 
        }
    public void setCreatedAt(Timestamp createdAt) { 
        this.createdAt = createdAt; 
        }

    public Timestamp getUpdatedAt() { 
        return updatedAt; 
        }
    public void setUpdatedAt(Timestamp updatedAt) {
         this.updatedAt = updatedAt; 
         }

    public Boolean getActive() { 
        return active; 
        }
    public void setActive(Boolean active) {
         this.active = active; 
         }
}
