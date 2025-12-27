package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_portfolios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userid;
    private String portfolioName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean active = true;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}