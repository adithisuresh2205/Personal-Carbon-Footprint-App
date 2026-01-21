package com.lifestyle.survey.service;

import com.lifestyle.survey.dto.GoalRequestDTO;
import com.lifestyle.survey.dto.ProgressUpdateDTO;
import com.lifestyle.survey.entity.Goal;
import com.lifestyle.survey.entity.GoalProgress;
import com.lifestyle.survey.repository.GoalProgressRepository;
import com.lifestyle.survey.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private GoalProgressRepository progressRepository;

    @Autowired
    private BadgeService badgeService;

 
    public Goal createGoal(GoalRequestDTO dto) {
        Goal goal = new Goal();
        goal.setUserEmail(dto.getUserEmail());
        goal.setGoalType(dto.getGoalType());
        goal.setTargetValue(dto.getTargetValue());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setStatus("ACTIVE");

        return goalRepository.save(goal);
    }

   
    public void updateProgress(ProgressUpdateDTO dto) {

        Goal goal = goalRepository.findById(dto.getGoalId())
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        double percentage = (dto.getCurrentValue() / goal.getTargetValue()) * 100;

        GoalProgress progress = new GoalProgress();
        progress.setGoalId(goal.getId());
        progress.setCurrentValue(dto.getCurrentValue());
        progress.setPercentage(percentage);

        progressRepository.save(progress);

        if (percentage >= 100 && goal.getStatus().equals("ACTIVE")) {
            goal.setStatus("COMPLETED");
            goalRepository.save(goal);

         
            badgeService.assignCompletionBadge(goal.getUserEmail());
        }
    }
}
