package com.example.demo.repository;

import com.example.demo.model.RiskThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {
    RiskThreshold findByActiveTrue();
}