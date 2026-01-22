package com.example.demo.model;

public class AuthRequest {
    private String username;
    private String password;

    // This is the method the Controller is looking
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}