package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    @Autowired
    private UserPortfolioService portfolioService;

    @GetMapping
    public List<UserPortfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @GetMapping("/user/{userid}")
    public List<UserPortfolio> getPortfoliosByUserId(@PathVariable Long userid) {
        return portfolioService.findByUserId(userid);
    }

    @PostMapping
    public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio) {
        return portfolioService.savePortfolio(portfolio);
    }
}
