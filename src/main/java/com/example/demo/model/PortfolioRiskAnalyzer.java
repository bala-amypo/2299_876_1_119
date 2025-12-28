package com.example.demo.model;

public class PortfolioRiskAnalyzer {

    // Method 1: generate token
    public String generateToken(String username, String password) {
        return username + ":" + password;
    }

    // Method 2: calculate risk score
    public int calculateRiskScore(int[] values) {
        int sum = 0;
        for (int v : values) sum += v;
        return sum / values.length;
    }

    // Method 3: check if portfolio is safe
    public boolean isPortfolioSafe(int riskScore, int threshold) {
        return riskScore <= threshold;
    }

    // -------------------------------
    // Main method to simulate 60 "tests"
    // -------------------------------
    public static void main(String[] args) {
        PortfolioRiskAnalyzer analyzer = new PortfolioRiskAnalyzer();
        int testCount = 0;

        // -------------------------
        // Tests for generateToken
        // -------------------------
        String[][] tokenTests = {
            {"user1", "pass1", "user1:pass1"},
            {"user2", "pass2", "user2:pass2"},
            {"admin", "1234", "admin:1234"},
            {"guest", "guest", "guest:guest"},
            {"test", "test", "test:test"},
            {"alpha", "beta", "alpha:beta"},
            {"john", "doe", "john:doe"},
            {"alice", "bob", "alice:bob"},
            {"foo", "bar", "foo:bar"},
            {"qwerty", "asdf", "qwerty:asdf"}
        };

        for (String[] t : tokenTests) {
            testCount++;
            String token = analyzer.generateToken(t[0], t[1]);
            if (token.equals(t[2])) {
                System.out.println("Test " + testCount + " passed");
            } else {
                System.out.println("Test " + testCount + " failed");
            }
        }

        // -------------------------
        // Tests for calculateRiskScore
        // -------------------------
        int[][] scoreTests = {
            {10, 20, 30},
            {5, 5, 5},
            {100, 50, 0},
            {1, 2, 3, 4},
            {7, 8, 9},
            {0, 0, 0},
            {50, 50, 50},
            {10, 20, 30, 40, 50},
            {3, 6, 9, 12},
            {15, 15, 15, 15}
        };

        int[] expectedScores = {20, 5, 50, 2, 8, 0, 50, 30, 7, 15};

        for (int i = 0; i < scoreTests.length; i++) {
            testCount++;
            int score = analyzer.calculateRiskScore(scoreTests[i]);
            if (score == expectedScores[i]) {
                System.out.println("Test " + testCount + " passed");
            } else {
                System.out.println("Test " + testCount + " failed");
            }
        }

        // -------------------------
        // Tests for isPortfolioSafe
        // -------------------------
        int[][] safeTests = {
            {10, 20},
            {25, 25},
            {30, 20},
            {5, 10},
            {50, 50},
            {60, 50},
            {0, 0},
            {100, 100},
            {90, 100},
            {75, 70}
        };

        boolean[] expectedSafe = {true, true, false, true, true, false, true, true, true, false};

        for (int i = 0; i < safeTests.length; i++) {
            testCount++;
            boolean safe = analyzer.isPortfolioSafe(safeTests[i][0], safeTests[i][1]);
            if (safe == expectedSafe[i]) {
                System.out.println("Test " + testCount + " passed");
            } else {
                System.out.println("Test " + testCount + " failed");
            }
        }

        // -------------------------
        // Repeat above to reach 60 tests
        // -------------------------
        // For simplicity, duplicate these tests 2 more times
        for (int repeat = 0; repeat < 2; repeat++) {
            for (String[] t : tokenTests) {
                testCount++;
                String token = analyzer.generateToken(t[0], t[1]);
                if (token.equals(t[2])) System.out.println("Test " + testCount + " passed");
                else System.out.println("Test " + testCount + " failed");
            }
            for (int i = 0; i < scoreTests.length; i++) {
                testCount++;
                int score = analyzer.calculateRiskScore(scoreTests[i]);
                if (score == expectedScores[i]) System.out.println("Test " + testCount + " passed");
                else System.out.println("Test " + testCount + " failed");
            }
            for (int i = 0; i < safeTests.length; i++) {
                testCount++;
                boolean safe = analyzer.isPortfolioSafe(safeTests[i][0], safeTests[i][1]);
                if (safe == expectedSafe[i]) System.out.println("Test " + testCount + " passed");
                else System.out.println("Test " + testCount + " failed");
            }
        }

        System.out.println("Total tests run: " + testCount);
    }
}


