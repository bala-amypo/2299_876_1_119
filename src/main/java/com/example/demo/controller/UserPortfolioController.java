// package com.example.demo.controller;

// import com.example.demo.model.UserPortfolio;
// import com.example.demo.service.UserPortfolioService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/portfolios")
// public class UserPortfolioController {

//     private final UserPortfolioService portfolioService;

//     public UserPortfolioController(UserPortfolioService portfolioService) {
//         this.portfolioService = portfolioService;
//     }

//     // POST /api/portfolios
//     @PostMapping
//     public UserPortfolio createPortfolio(@RequestBody UserPortfolio portfolio) {
//         return portfolioService.createPortfolio(portfolio);
//     }

//     // GET /api/portfolios/{id}
//     @GetMapping("/{id}")
//     public UserPortfolio getPortfolioById(@PathVariable Long id) {
//         return portfolioService.getPortfolioById(id);
//     }

//     // GET /api/portfolios/user/{userId}
//     @GetMapping("/user/{userId}")
//     public List<UserPortfolio> getPortfoliosByUser(@PathVariable Long userId) {
//         return portfolioService.getPortfoliosByUser(userId);
//     }
// }




package com.example.demo.controller;

import com.example.demo.model.UserPortfolio;
import com.example.demo.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class UserPortfolioController {

    @Autowired
    private UserPortfolioService service;

    // Create a new portfolio
    @PostMapping
    public ResponseEntity<UserPortfolio> createPortfolio(@RequestBody UserPortfolio portfolio) {
        return ResponseEntity.ok(service.createPortfolio(portfolio));
    }

    // Get portfolio by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserPortfolio> getPortfolioById(@PathVariable Long id) {
        return service.getPortfolioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get portfolios by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPortfolio>> getPortfoliosByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getPortfoliosByUserId(userId));
    }
}
