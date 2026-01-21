package com.lifestyle.survey.repository;

import com.lifestyle.survey.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserEmail(String userEmail);
}
