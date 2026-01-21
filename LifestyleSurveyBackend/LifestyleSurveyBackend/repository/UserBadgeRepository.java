package com.lifestyle.survey.repository;

import com.lifestyle.survey.entity.UserBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {

    @Query("SELECT u.userEmail, SUM(u.points) FROM UserBadge u GROUP BY u.userEmail ORDER BY SUM(u.points) DESC")
    List<Object[]> getLeaderboard();
}
