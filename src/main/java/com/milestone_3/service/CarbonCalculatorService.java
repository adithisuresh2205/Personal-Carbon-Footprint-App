package com.milestone_3.service;



import org.springframework.stereotype.Service;

import com.milestone_3.entity.CarbonLog;
import com.milestone_3.entity.Survey;

import java.time.LocalDate;

@Service
public class CarbonCalculatorService {

    public CarbonLog calculateCarbon(Survey survey) {

        int totalEmission =
                (survey.getElectricityUsage() * 2) +
                (survey.getFuelUsage() * 3);

        CarbonLog log = new CarbonLog();
        log.setUsername(survey.getUsername());
        log.setTotalEmission(totalEmission);
        log.setDate(LocalDate.now());

        return log;
    }
}
