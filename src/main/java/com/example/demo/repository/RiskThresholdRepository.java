package com.example.demo.repository;

import com.example.demo.model.RiskThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RiskThresholdRepository extends JpaRepository<RiskThreshold, Long> {
    // Exact method name required by Step 0.4
    Optional<RiskThreshold> findByActiveTrue();
}