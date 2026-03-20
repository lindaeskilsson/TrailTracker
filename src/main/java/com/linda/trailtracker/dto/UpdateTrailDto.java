package com.linda.trailtracker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateTrailDto {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name can have at most 50 chars")
    private String name;

    @Min(value = 1, message = "Distance must be at least 1 km")
    private double distanceKm;

    @Min(value = 0, message = "Elevation gain cannot be negative")
    private int elevationGain;

    @NotBlank(message = "Description is required")
    @Size(max = 200, message = "Description can have at most 200 chars")
    private String description;

    @NotBlank(message = "Location is required")
    @Size(max = 30, message = "Location can have at most 30 chars")
    private String location;

    @Min(value = 1, message = "Time must be more than one minute")
    private int timeMinutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double
    getDistanceKm() {
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

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }
}
