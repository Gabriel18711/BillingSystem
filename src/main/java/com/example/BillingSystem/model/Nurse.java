package com.example.BillingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String competenceLevel;  // E.g., "Junior", "Senior", "Expert"
    private Double hourlyRate;  // The nurse's hourly rate based on competence level

    // Constructors, Getters, Setters

    public Nurse() {}

    public Nurse(String name, String competenceLevel, Double hourlyRate) {
        this.name = name;
        this.competenceLevel = competenceLevel;
        this.hourlyRate = hourlyRate;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompetenceLevel() {
        return competenceLevel;
    }

    public void setCompetenceLevel(String competenceLevel) {
        this.competenceLevel = competenceLevel;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

