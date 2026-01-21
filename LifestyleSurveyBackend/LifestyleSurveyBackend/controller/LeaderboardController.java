package com.lifestyle.survey.controller;

import com.lifestyle.survey.repository.UserBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    @Autowired
    private UserBadgeRepository repo;

    @GetMapping
    public List<Object[]> leaderboard() {
        return repo.getLeaderboard();
    }
}
