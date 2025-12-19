package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPortfolioService {

    @Autowired
    private UserPortfolioRepository portfolioRepository;

    public UserPortfolio savePortfolio(UserPortfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public List<UserPortfolio> findByUserId(Long userid) {
        return portfolioRepository.findByUserid(userid);
    }

    public List<UserPortfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }
}
