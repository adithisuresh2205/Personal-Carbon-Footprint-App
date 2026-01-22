package com.example.demo.controller;

import com.example.demo.model.UserGoal;
import com.example.demo.model.User;
import com.example.demo.model.Goal;
import com.example.demo.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "http://localhost:3000") // Allow React to connect
public class GoalController {

    @Autowired
    private GoalService goalService;

    // Endpoint to get user's current active goals
    @GetMapping("/active/{userId}")
    public ResponseEntity<List<UserGoal>> getActiveGoals(@PathVariable Long userId) {
        return ResponseEntity.ok(goalService.getActiveGoals(userId));
    }

    // Endpoint to "Accept" or "Assign" a goal
    @PostMapping("/assign")
    public ResponseEntity<UserGoal> assignGoal(@RequestParam Long userId, @RequestParam Long goalId) {
        // Note: In a real app, you'd get the User from the Security Session/JWT
        User user = new User(); 
        user.setId(userId); 
        
        UserGoal assigned = goalService.assignGoalToUser(user, goalId);
        return ResponseEntity.ok(assigned);
    }
}