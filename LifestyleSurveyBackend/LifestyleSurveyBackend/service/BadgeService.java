package com.lifestyle.survey.service;

import com.lifestyle.survey.entity.UserBadge;
import com.lifestyle.survey.repository.UserBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadgeService {

    @Autowired
    private UserBadgeRepository userBadgeRepository;

    public void assignCompletionBadge(String email) {
        UserBadge badge = new UserBadge();
        badge.setUserEmail(email);
        badge.setBadgeName("Goal Achiever");
        badge.setPoints(50);

        userBadgeRepository.save(badge);
    }
}
