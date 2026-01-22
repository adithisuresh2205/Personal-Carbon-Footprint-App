package com.example.demo.service;
import com.example.demo.model.UserGoal;
import com.example.demo.model.User;
import com.example.demo.repository.UserGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GoalService {

    @Autowired
    private UserGoalRepository userGoalRepository;

    @Autowired
    private GoalRepository goalRepository;

    // Logic to assign a goal to a user
    public UserGoal assignGoalToUser(User user, Long goalId) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        UserGoal userGoal = new UserGoal();
        userGoal.setUser(user);
        userGoal.setGoal(goal);
        userGoal.setStartDate(LocalDate.now());
        userGoal.setEndDate(LocalDate.now().plusWeeks(2)); // Default to 2-week challenges
        userGoal.setStatus("ACTIVE");
        userGoal.setCurrentProgress(0.0);

        return userGoalRepository.save(userGoal);
    }

    // Get all goals currently active for a user
    public List<UserGoal> getActiveGoals(Long userId) {
        return userGoalRepository.findByUserIdAndStatus(userId, "ACTIVE");
    }
}