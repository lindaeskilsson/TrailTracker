package com.linda.trailtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private LocalDate date;

    @Positive
    private double distanceKm;
    private int timeMinutes;
    private int elevationGain;
    private String description;

    protected Trail() {}

    protected Trail(String name, LocalDate date, double distanceKm, int timeMinutes, int elevationGain, String description) {
        this.name = name;
        this.distanceKm = distanceKm;
        this.timeMinutes = timeMinutes;
        this.elevationGain = elevationGain;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public LocalDate getDate() {
        return date;
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
    public void setName(String name) {
        this.name = name;
    }
}
