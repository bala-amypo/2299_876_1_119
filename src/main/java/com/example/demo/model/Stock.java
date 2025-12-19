package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stock", uniqueConstraints = @UniqueConstraint(columnNames = "ticker"))
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker;

    private String companyName;

    private String sector;

    private boolean active = true;

    public Stock() {}

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
