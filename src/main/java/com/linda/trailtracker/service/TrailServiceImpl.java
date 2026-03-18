package com.linda.trailtracker.service;

import com.linda.trailtracker.dto.CreateTrailDto;
import com.linda.trailtracker.dto.TrailDto;
import com.linda.trailtracker.dto.UpdateTrailDto;
import com.linda.trailtracker.entity.Trail;
import com.linda.trailtracker.mapper.TrailMapper;
import com.linda.trailtracker.repository.TrailRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrailServiceImpl implements TrailService {

    private final TrailRepository trailRepository;
    private final TrailMapper trailMapper;

    public TrailServiceImpl(TrailRepository trailRepository, TrailMapper trailMapper){
        this.trailRepository = trailRepository;
        this.trailMapper = trailMapper;
    }

    @Override
    public List<TrailDto> getAllTrails() {
        return trailRepository.findAll()
                .stream()
                .map(trailMapper::toDto)
                .toList();
    }

    @Override
    public TrailDto getTrailDtoById(Long id) {
        Trail trail = trailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trail not found with id: " + id));

        return trailMapper.toDto(trail);
    }

    @Override
    public TrailDto createTrail(CreateTrailDto createTrailDto) {
        if (trailRepository.existsByNameAndLocation(createTrailDto.getName(), createTrailDto.getLocation())) {
            throw new RuntimeException("Trail already exists");
        }

        Trail trail = trailMapper.toEntity(createTrailDto);
        trail.setCreatedAt(LocalDateTime.now());

        Trail savedTrail = trailRepository.save(trail);
        return trailMapper.toDto(savedTrail);
    }

    @Override
    public TrailDto updateTrail(Long id, UpdateTrailDto updateTrailDto) {
        Trail existingTrail = trailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trail not found with id: " + id));

        trailMapper.updateEntity(updateTrailDto, existingTrail);

        Trail updatedTrail = trailRepository.save(existingTrail);
        return trailMapper.toDto(updatedTrail);
    }

    @Override
    public void deleteTrail(Long id) {
        Trail trail = trailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trail not found with id: " + id));

        trailRepository.delete(trail);
    }

    @Override
    public List<TrailDto> getTrailsByName(String name) {
        return trailRepository.findByName(name)
                .stream()
                .map(trailMapper::toDto)
                .toList();
    }

    @Override
    public List<TrailDto> getTrailsByLocation(String location) {
        return trailRepository.findByLocation(location)
                .stream()
                .map(trailMapper::toDto)
                .toList();
    }

    public List<TrailDto> getTrailsByDistanceBetween(double min, double max) {
        return trailRepository.findByDistanceKmBetween(min, max)
                .stream()
                .map(trailMapper::toDto)
                .toList();
    }

    @Override
    public List<TrailDto> getTrailsByLocationAndDistance(String location, double distanceKm) {
        return trailRepository.findByLocationAndDistanceKm(location, distanceKm)
                .stream()
                .map(trailMapper::toDto)
                .toList();
    }


}