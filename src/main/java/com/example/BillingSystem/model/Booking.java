package com.example.BillingSystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double distance;  // Distance in kilometers/miles
    private Integer durationInHours;  // Duration of the service in hours
    private LocalDateTime serviceTime;  // Date and time of the service

    @ManyToOne
    private ServiceType serviceType;

    @ManyToOne
    private Nurse nurse;

    // Constructors, Getters, Setters

    public Booking() {}

    public Booking(Double distance, Integer durationInHours, LocalDateTime serviceTime, ServiceType serviceType, Nurse nurse) {
        this.distance = distance;
        this.durationInHours = durationInHours;
        this.serviceTime = serviceTime;
        this.serviceType = serviceType;
        this.nurse = nurse;
    }

    // Price Calculation Logic
    public Double calculatePrice() {
        // Example calculation:
        // baseRate of service + (nurse's hourly rate * hours) + (distance surcharge, e.g., 0.5 per km)

        double basePrice = serviceType.getBaseRate();
        double nursePrice = nurse.getHourlyRate() * durationInHours;
        double distanceSurcharge = 0.5 * distance;

        // Additional pricing logic based on time, like after-hours surcharge, could be added here
        // e.g., increase price for late-night services
        if (serviceTime.getHour() >= 22 || serviceTime.getHour() < 6) {
            basePrice *= 1.2;  // 20% surcharge for night hours
        }

        return basePrice + nursePrice + distanceSurcharge;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(Integer durationInHours) {
        this.durationInHours = durationInHours;
    }

    public LocalDateTime getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(LocalDateTime serviceTime) {
        this.serviceTime = serviceTime;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }
}

