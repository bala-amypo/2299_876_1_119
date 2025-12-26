package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PortfolioRiskAnalyzerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private PortfolioRiskAnalyzer portfolioRiskAnalyzer;

    @Test
    void testUserFoundByEmail() {

        // Create dummy user
        User user = new User();
        user.setEmail("test@email.com");

        // ✅ CORRECT Optional usage
        when(userService.findByEmail("test@email.com"))
                .thenReturn(Optional.of(user));

        boolean result = portfolioRiskAnalyzer.checkUser("test@email.com");

        assertTrue(result);
    }

    @Test
    void testUserNotFoundByEmail() {

        // ✅ Optional.empty() when user not found
        when(userService.findByEmail("notfound@email.com"))
                .thenReturn(Optional.empty());

        boolean result = portfolioRiskAnalyzer.checkUser("notfound@email.com");

        assertTrue(!result);
    }
}
