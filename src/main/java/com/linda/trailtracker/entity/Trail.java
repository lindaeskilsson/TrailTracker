package com.linda.trailtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private LocalDateTime createdAt;

    @Positive
    private double distanceKm;
    private int timeMinutes;
    private int elevationGain;
    private String description;
    private String location;

    public Trail() {}

    public Trail(String name, LocalDateTime createdAt, double distanceKm, int timeMinutes, int elevationGain, String description, String location) {
        this.name = name;
        this.createdAt = createdAt;
        this.distanceKm = distanceKm;
        this.timeMinutes = timeMinutes;
        this.elevationGain = elevationGain;
        this.description = description;
        this.location = location;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public double getDistanceKm() {
        return distanceKm;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }
    public int getElevationGain() {
        return elevationGain;
    }
    public String getDescription() {
        return description;
    }
    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public void setElevationGain(int elevationGain) {
        this.elevationGain = elevationGain;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
