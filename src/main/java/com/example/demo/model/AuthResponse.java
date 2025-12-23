// // AuthResponse.java
// package com.example.demo.model;

// public class AuthResponse {
//     private Long userId;
//     private String username;
//     private String token;

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getToken() { return token; }
//     public void setToken(String token) { this.token = token; }
// }




package com.example.demo.model;

public class AuthResponse {
    private String token;
    private String username;

    public AuthResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }

    // Getters
    public String getToken() { return token; }
    public String getUsername() { return username; }
}
