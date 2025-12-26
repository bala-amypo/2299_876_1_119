package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ticker;

    private String companyName;
    private String sector;
    private Boolean active = true;

    public Stock(String ticker, String companyName, String sector, Boolean active) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.sector = sector;
        this.active = active;
    }
}