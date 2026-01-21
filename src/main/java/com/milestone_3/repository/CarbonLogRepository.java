package com.milestone_3.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.milestone_3.entity.CarbonLog;

import java.util.List;

public interface CarbonLogRepository
        extends JpaRepository<CarbonLog, Integer> {

    List<CarbonLog> findByUsernameOrderByDateDesc(String username);
}

