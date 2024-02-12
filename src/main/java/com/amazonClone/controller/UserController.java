package com.amazonClone.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonClone.dto.LoginRequest;
import com.amazonClone.model.User;
import com.amazonClone.repository.UserRepository;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User userDto) {
        String firstName = userDto.getFirstname();
        String lastName = userDto.getLastname();
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        String mobile = userDto.getMobile();

        if (firstName == null || lastName == null || email == null || password == null || mobile == null) {
            throw new IllegalArgumentException("All fields are important..!");
        }

        if (userRepository.findById(email).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        User user = new User(firstName, lastName, email, passwordEncoder.encode(password), mobile);
        userRepository.save(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return user.generateAuthToken();
    }

    // Other methods...

}
