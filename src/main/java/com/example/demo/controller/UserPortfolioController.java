package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@Tag(name = "User Portfolio Management")
public class UserPortfolioController {
    private final UserPortfolioService service;

    public UserPortfolioController(UserPortfolioService service) {
        this.service = service;
    }

    @PostMapping
    public UserPortfolio create(@RequestBody UserPortfolio portfolio) {
        return service.createPortfolio(portfolio);
    }

    @GetMapping("/{id}")
    public UserPortfolio getById(@PathVariable Long id) {
        return service.getPortfolioById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPortfolio> getByUser(@PathVariable Long userId) {
        return service.getPortfoliosByUser(userId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivatePortfolio(id);
    }
}