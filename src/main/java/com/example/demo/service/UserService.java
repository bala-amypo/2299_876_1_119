// // UserService.java
// package com.example.demo.service;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// public class UserService {

//     private final UserRepository userRepository;

//     public UserService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     // Create/Register a new user
//     public User register(User user) {
//         return userRepository.save(user);
//     }

//     // Find user by username (for login)
//     public Optional<User> findByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }
// }


package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(Long id) {
        return "MockUser";
    }
}
