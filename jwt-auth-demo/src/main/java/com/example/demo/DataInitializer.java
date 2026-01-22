package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            if (repository.findByUsername("testuser").isEmpty()) {
                User testUser = new User();
                testUser.setUsername("testuser");
                testUser.setPassword("password123");
                repository.save(testUser);
                System.out.println("--- Test User Created in Database ---");
            }
        };
    }
}