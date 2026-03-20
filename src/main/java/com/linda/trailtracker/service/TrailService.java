package com.linda.trailtracker.service;


import com.linda.trailtracker.dto.CreateTrailDto;
import com.linda.trailtracker.dto.TrailDto;
import com.linda.trailtracker.dto.UpdateTrailDto;

import java.util.List;

public interface TrailService {

    List<TrailDto> getAllTrails();

    TrailDto getTrailDtoById(Long id);

    TrailDto createTrail(CreateTrailDto createTrailDto);

    TrailDto updateTrail(Long id, UpdateTrailDto updateTrailDto);

    void deleteTrail(Long id);

}
