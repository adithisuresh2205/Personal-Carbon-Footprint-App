package com.lifestyle.survey.dto;

import java.time.LocalDate;

public class GoalRequestDTO {

    private String userEmail;
    private String goalType;
    private Double targetValue;
    private LocalDate startDate;
    private LocalDate endDate;

  
    public String getUserEmail() {
        return userEmail;
    }

    public String getGoalType() {
        return goalType;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
