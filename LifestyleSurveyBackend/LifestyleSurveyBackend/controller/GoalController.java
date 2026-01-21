package com.lifestyle.survey.controller;

import com.lifestyle.survey.dto.GoalRequestDTO;
import com.lifestyle.survey.dto.ProgressUpdateDTO;
import com.lifestyle.survey.entity.Goal;
import com.lifestyle.survey.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    public Goal createGoal(@RequestBody GoalRequestDTO dto) {
        return goalService.createGoal(dto);
    }

    @PostMapping("/progress")
    public void updateProgress(@RequestBody ProgressUpdateDTO dto) {
        goalService.updateProgress(dto);
    }
}
