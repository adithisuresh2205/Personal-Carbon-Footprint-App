package com.milestone_3.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CarbonLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private int totalEmission;
    private LocalDate date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalEmission() {
        return totalEmission;
    }

    public void setTotalEmission(int totalEmission) {
        this.totalEmission = totalEmission;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

