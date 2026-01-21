package com.lifestyle.survey.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserBadge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String badgeName;
    private Integer points;
    private LocalDateTime awardedAt = LocalDateTime.now();

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public Integer getPoints() {
        return points;
    }
}
