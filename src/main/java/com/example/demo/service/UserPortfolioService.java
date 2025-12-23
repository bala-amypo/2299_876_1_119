// package com.example.demo.service;

// import com.example.demo.model.User;
// import com.example.demo.model.UserPortfolio;
// import com.example.demo.repository.UserPortfolioRepository;
// import com.example.demo.repository.UserRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class UserPortfolioService {

//     private final UserPortfolioRepository portfolioRepository;
//     private final UserRepository userRepository;

//     public UserPortfolioService(UserPortfolioRepository portfolioRepository,
//                                 UserRepository userRepository) {
//         this.portfolioRepository = portfolioRepository;
//         this.userRepository = userRepository;
//     }

//     // POST /api/portfolios
//     public UserPortfolio createPortfolio(UserPortfolio portfolio) {
//         Long userId = portfolio.getUser().getId();

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found with id " + userId));

//         portfolio.setUser(user);
//         return portfolioRepository.save(portfolio);
//     }

//     // GET /api/portfolios/{id}
//     public UserPortfolio getPortfolioById(Long id) {
//         return portfolioRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Portfolio not found with id " + id));
//     }

//     // GET /api/portfolios/user/{userId}
//     public List<UserPortfolio> getPortfoliosByUser(Long userId) {
//         return portfolioRepository.findByUserId(userId);
//     }
// }


package com.example.demo.service;

import com.example.demo.model.UserPortfolio;
import com.example.demo.repository.UserPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPortfolioService {

    @Autowired
    private UserPortfolioRepository repository;

    // Create a new portfolio
    public UserPortfolio createPortfolio(UserPortfolio portfolio) {
        return repository.save(portfolio);
    }

    // Get portfolio by ID
    public Optional<UserPortfolio> getPortfolioById(Long id) {
        return repository.findById(id);
    }

    // Get portfolios by user ID
    public List<UserPortfolio> getPortfoliosByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
