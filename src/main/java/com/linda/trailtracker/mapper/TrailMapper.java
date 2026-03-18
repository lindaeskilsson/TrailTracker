package com.linda.trailtracker.mapper;

import com.linda.trailtracker.dto.CreateTrailDto;
import com.linda.trailtracker.dto.TrailDto;
import com.linda.trailtracker.dto.UpdateTrailDto;
import com.linda.trailtracker.entity.Trail;
import org.springframework.stereotype.Component;

@Component
public class TrailMapper {

    //CreateTrailDto -> Trail
    // används för att skapa en ny trail.
    public Trail toEntity(CreateTrailDto createTrailDto){
        Trail trail = new Trail();
        trail.setName(createTrailDto.getName());
        trail.setDistanceKm(createTrailDto.getDistanceKm());
        trail.setElevationGain(createTrailDto.getElevationGain());
        trail.setTimeMinutes(createTrailDto.getTimeMinutes());
        trail.setDescription(createTrailDto.getDescription());
        trail.setLocation(createTrailDto.getLocation());
        return trail;
    }

    // UpdateTrailDto -> uppdatera befintlig Trail
    //används för att uppdatera en befinlig trail
    public void updateEntity(UpdateTrailDto updateTrailDto, Trail trail){
        trail.setName(updateTrailDto.getName());
        trail.setDistanceKm(updateTrailDto.getDistanceKm());
        trail.setElevationGain(updateTrailDto.getElevationGain());
        trail.setTimeMinutes(updateTrailDto.getTimeMinutes());
        trail.setDescription(updateTrailDto.getDescription());
        trail.setLocation(updateTrailDto.getLocation());
    }

    // Trail -> TrailDto
    //används för att skicak tillbaka data ut från backend.
    public TrailDto toDto(Trail trail){
        return new TrailDto(
                trail.getId(),
                trail.getName(),
                trail.getDistanceKm(),
                trail.getElevationGain(),
                trail.getTimeMinutes(),
                trail.getDescription(),
                trail.getLocation(),
                trail.getCreatedAt()
        );
    }
}
