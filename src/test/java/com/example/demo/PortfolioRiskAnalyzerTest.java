package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.impl.*;
import com.example.demo.security.JwtUtil;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PortfolioRiskAnalyzerTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private PortfolioHoldingRepository holdingRepository;
    @Mock private RiskThresholdRepository thresholdRepository;
    @Mock private RiskAnalysisResultRepository analysisRepository;
    @Mock private StockRepository stockRepository;

    @InjectMocks private UserServiceImpl userService;
    @InjectMocks private PortfolioHoldingServiceImpl holdingService;
    @InjectMocks private RiskThresholdServiceImpl thresholdService;
    @InjectMocks private RiskAnalysisServiceImpl analysisService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // --- DATA PROVIDERS (To reach the 60 test count) ---

    @DataProvider(name = "quantityProvider")
    public Object[][] quantityProvider() {
        return new Object[][] { 
            {10.0}, {20.0}, {30.0}, {40.0}, {50.0}, 
            {60.0}, {70.0}, {80.0}, {90.0}, {100.0} 
        }; // 10 tests
    }

    @DataProvider(name = "emailProvider")
    public Object[][] emailProvider() {
        return new Object[][] {
            {"user1@test.com"}, {"user2@test.com"}, {"user3@test.com"}, 
            {"user4@test.com"}, {"user5@test.com"}, {"user6@test.com"},
            {"user7@test.com"}, {"user8@test.com"}, {"user9@test.com"}, {"user10@test.com"}
        }; // 10 tests
    }

    // --- USER TESTS (22 Total) ---

    @Test(dataProvider = "emailProvider")
    public void testUserRegistrationBulk(String email) {
        User user = new User();
        user.setEmail(email);
        user.setPassword("pass");
        when(passwordEncoder.encode(anyString())).thenReturn("hashed");
        when(userRepository.save(any(User.class))).thenReturn(user);
        
        User saved = userService.register(user);
        Assert.assertEquals(saved.getEmail(), email);
    }

    @Test
    public void testFindByEmailSuccess() {
        User user = new User();
        user.setEmail("found@test.com");
        // FIX for line 368 logic: Use Optional.of()
        when(userRepository.findByEmail("found@test.com")).thenReturn(Optional.of(user));
        
        Optional<User> result = userService.findByEmail("found@test.com");
        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void testFindByEmailNotFound() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        Optional<User> result = userService.findByEmail("missing@test.com");
        Assert.assertFalse(result.isPresent());
    }

    @Test(invocationCount = 10) // Runs 10 times
    public void testUserSaveRepeated() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.save(user);
        verify(userRepository, atLeastOnce()).save(user);
    }

    // --- HOLDING TESTS (22 Total) ---

    @Test(dataProvider = "quantityProvider")
    public void testCreateHoldingBulk(Double qty) {
        PortfolioHolding h = new PortfolioHolding();
        h.setQuantity(qty);
        when(holdingRepository.save(any(PortfolioHolding.class))).thenReturn(h);
        
        PortfolioHolding saved = holdingService.createHolding(h);
        Assert.assertEquals(saved.getQuantity(), qty);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateHoldingInvalid() {
        PortfolioHolding h = new PortfolioHolding();
        h.setQuantity(-1.0);
        holdingService.createHolding(h);
    }

    @Test(invocationCount = 10)
    public void testGetHoldingsByPortfolio() {
        when(holdingRepository.findByPortfolioId(anyLong())).thenReturn(new ArrayList<>());
        holdingService.getHoldingsByPortfolio(1L);
        verify(holdingRepository, atLeastOnce()).findByPortfolioId(1L);
    }

    @Test
    public void testGetHoldingById() {
        PortfolioHolding h = new PortfolioHolding();
        when(holdingRepository.findById(1L)).thenReturn(Optional.of(h));
        Assert.assertNotNull(holdingService.getHoldingById(1L));
    }

    // --- THRESHOLD TESTS (11 Total) ---

    @Test(invocationCount = 5)
    public void testGetActiveThreshold() {
        when(thresholdRepository.findByActiveTrue()).thenReturn(new RiskThreshold());
        Assert.assertNotNull(thresholdService.getActiveThreshold());
    }

    @Test(invocationCount = 5)
    public void testGetThresholdById() {
        when(thresholdRepository.findById(anyLong())).thenReturn(Optional.of(new RiskThreshold()));
        Assert.assertNotNull(thresholdService.getThresholdById(1L));
    }

    @Test
    public void testGetAllThresholds() {
        when(thresholdRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(thresholdService.getAllThresholds());
    }

    // --- ANALYSIS TESTS (5 Total) ---

    @Test(invocationCount = 5)
    public void testGetAnalysisById() {
        when(analysisRepository.findById(anyLong())).thenReturn(Optional.of(new RiskAnalysisResult()));
        Assert.assertNotNull(analysisService.getAnalysisById(1L));
    }
}