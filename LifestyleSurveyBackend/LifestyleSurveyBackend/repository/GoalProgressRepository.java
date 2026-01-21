package com.lifestyle.survey.repository;

import com.lifestyle.survey.entity.GoalProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalProgressRepository extends JpaRepository<GoalProgress, Long> {
}
