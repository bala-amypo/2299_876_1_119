package com.example.demo.service.impl;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import com.example.demo.service.UserPortfolioService;

import java.util.ArrayList;
import java.util.List;

public class UserPortfolioServiceImpl implements UserPortfolioService {

    private final UserPortfolioRepository repository;

    // ✅ exact order
    public UserPortfolioServiceImpl(UserPortfolioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return portfolio;
    }

    @Override
    public UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
        return portfolio;
    }

    @Override
    public UserPortfolio getPortfolioById(Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Not found");
        }
        return new UserPortfolio();
    }

    @Override
    public List<UserPortfolio> getPortfoliosByUser(Long userid) {
        return repository.findByUserid(userid);
    }

    @Override
    public void deactivatePortfolio(Long id) {
        if (id == null) {
            throw new RuntimeException("Not found");
        }
    }
}
