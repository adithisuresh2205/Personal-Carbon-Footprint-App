package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "lifestyle_survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // Use @Column to map the Java name to the MySQL name
    @Column(name = "monthly_mileage")
    private Double monthlyMileage;

    @Column(name = "electricity_bill")
    private Double electricityBill;

    @Column(name = "diet_type")
    private String dietType;

    @Column(name = "carbon_footprint")
    private Double carbonFootprint;

    @CreationTimestamp // Automatically handles the date for you
    @Column(name = "submission_date", updatable = false)
    private LocalDateTime submissionDate;

    public Survey() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { 
    	this.id = id; 
    	}
    
    public String getUsername() { 
    	return username; 
    	}
    public void setUsername(String username) { 
    	this.username = username; 
    	}
    
    public Double getMonthlyMileage() { 
    	return monthlyMileage; 
    	}
    public void setMonthlyMileage(Double monthlyMileage) { 
    	this.monthlyMileage = monthlyMileage; 
    	}
    
    public Double getElectricityBill() { 
    	return electricityBill; 
    	}
    public void setElectricityBill(Double electricityBill) { 
    	this.electricityBill = electricityBill; 
    	}
    
    public String getDietType() { 
    	return dietType; 
    	}
    public void setDietType(String dietType) { 
    	this.dietType = dietType; 
    	}
    
    public Double getCarbonFootprint() { return carbonFootprint; }
    public void setCarbonFootprint(Double carbonFootprint) { this.carbonFootprint = carbonFootprint; }
}