package com.example.demo.controller;

import com.example.demo.model.Survey;
import com.example.demo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/survey") // Allows React to connect
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @PostMapping("/survey")
    public Survey saveSurvey(@RequestBody Survey survey) {
        // 1. Calculate
        double footprint = (survey.getMonthlyMileage() * 0.2) + (survey.getElectricityBill() * 0.5);
        survey.setCarbonFootprint(footprint);
        
        // 2. Save
        return surveyRepository.save(survey); 
    }
    }