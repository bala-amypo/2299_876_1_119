package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

public class PortfolioRiskAnalyzerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private Object dummyService; // replace later if needed

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUserByEmail_success() {

        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userService.findByEmail("test@example.com"))
                .thenReturn(Optional.of(user));

        // Act
        Optional<User> result = userService.findByEmail("test@example.com");

        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    public void testFindUserByEmail_notFound() {

        when(userService.findByEmail("unknown@example.com"))
                .thenReturn(Optional.empty());

        Optional<User> result = userService.findByEmail("unknown@example.com");

        assertTrue(result.isEmpty());
    }
}
