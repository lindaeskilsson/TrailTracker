package com.linda.trailtracker.repository;

import com.linda.trailtracker.entity.Trail;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailRepository extends ListCrudRepository<Trail, Long> {

    List<Trail> findByName(String name);

    List<Trail> findByLocation(String location);

    List<Trail> findByLocationAndDistanceKm(String location, double distanceKm);

    List<Trail> findByDistanceKmBetween(double min, double max);

    boolean existsByNameAndLocation(String name, String location);
}