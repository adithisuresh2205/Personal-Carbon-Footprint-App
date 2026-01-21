package com.milestone_3.controller;


import org.springframework.web.bind.annotation.*;

import com.milestone_3.entity.CarbonLog;
import com.milestone_3.entity.Survey;
import com.milestone_3.repository.CarbonLogRepository;
import com.milestone_3.service.CarbonCalculatorService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/carbon")
public class CarbonController {

    private final CarbonCalculatorService service;
    private final CarbonLogRepository repository;

    public CarbonController(CarbonCalculatorService service,
                            CarbonLogRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/calculate")
    public CarbonLog calculate(@RequestBody Survey survey) {

        CarbonLog log = service.calculateCarbon(survey);
        return repository.save(log);
    }

    @GetMapping("/history/{username}")
    public List<CarbonLog> history(@PathVariable String username) {
        return repository.findByUsernameOrderByDateDesc(username);
    }
}

