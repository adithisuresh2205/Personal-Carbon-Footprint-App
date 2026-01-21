package com.lifestyle.survey.entity;

import jakarta.persistence.*;

@Entity
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer points;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Integer getPoints() { return points; }
}
