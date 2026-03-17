package com.linda.trailtracker.service;

import com.linda.trailtracker.entity.Trail;
import com.linda.trailtracker.repository.TrailRepository;
import org.springframework.stereotype.Service;

@Service
public class TrailService {
    private final TrailRepository repository;

    public TrailService(TrailRepository repository) {
        this.repository = repository;
    }
}
