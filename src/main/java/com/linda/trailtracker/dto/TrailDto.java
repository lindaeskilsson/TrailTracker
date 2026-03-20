package com.linda.trailtracker.dto;

import java.time.LocalDateTime;

public class TrailDto {

    final Long id;
    private String name;
    private double distanceKm;
    private int elevationGain;
    private int timeMinutes;
    private String description;
    private String location;
    private LocalDateTime createdAt;

    public TrailDto(Long id, String name, double distanceKm, int elevationGain, int timeMinutes,
                    String description, String location, LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.distanceKm = distanceKm;
        this.elevationGain = elevationGain;
        this.timeMinutes = timeMinutes;
        this.description = description;
        this.location = location;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public int getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(int elevationGain) {
        this.elevationGain = elevationGain;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
