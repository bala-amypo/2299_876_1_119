package com.example.demo.repository;

import com.example.demo.model.UserPortfolio;
import java.util.List;

public interface UserPortfolioRepository {
    List<UserPortfolio> findByUserid(Long userid);
}
