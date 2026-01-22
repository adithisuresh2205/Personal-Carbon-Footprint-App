package com.example.demo.repository;

import com.example.demo.model.UserGoal;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoal, Long> {
    
    // Find all goals assigned to a specific user
    List<UserGoal> findByUser(User user);
    
    // Find goals by status (e.g., all "ACTIVE" goals for a user)
    List<UserGoal> findByUserIdAndStatus(Long userId, String status);
}