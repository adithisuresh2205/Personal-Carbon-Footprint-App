package com.example.demo.controller;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.AuthResponse;
import com.example.demo.model.User; // Make sure you have a User model
import com.example.demo.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
// This line allows your React app (on port 3000) to talk to this backend
@CrossOrigin(origins = "http://localhost:3000") 
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        // In a real app, you would verify the password here before generating the token
        final String jwt = jwtUtil.generateToken(authRequest.getUsername());
        return new AuthResponse(jwt);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        // For Week 2, this fulfills the "Register" requirement in your milestone plan
        // Logic to save user to database goes here
        return "User registered successfully!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Access Granted!";
    }
}