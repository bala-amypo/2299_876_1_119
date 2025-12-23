// // AuthController.java
// package com.example.demo.controller;

// import com.example.demo.model.*;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;

//     public AuthController(UserService userService) {
//         this.userService = userService;
//     }

//     // REGISTER
//     @PostMapping("/register")
//     public AuthResponse register(@RequestBody LoginRequest request) {
//         User user = new User();
//         user.setUsername(request.getUsername());
//         user.setPassword(request.getPassword());

//         userService.register(user);

//         AuthResponse response = new AuthResponse();
//         response.setUserId(user.getId());
//         response.setUsername(user.getUsername());
//         response.setToken("dummy-token"); // You can replace this with JWT later

//         return response;
//     }

//     // LOGIN
//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody LoginRequest request) {
//         User user = userService.findByUsername(request.getUsername())
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         if (!user.getPassword().equals(request.getPassword())) {
//             throw new RuntimeException("Invalid password");
//         }

//         AuthResponse response = new AuthResponse();
//         response.setUserId(user.getId());
//         response.setUsername(user.getUsername());
//         response.setToken("dummy-token"); // Replace with JWT later

//         return response;
//     }
// }



package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        User user = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, user.getUsername());
    }
}
