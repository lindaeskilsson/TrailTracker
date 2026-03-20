package com.linda.trailtracker.repository;

import com.linda.trailtracker.entity.Trail;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailRepository extends ListCrudRepository<Trail, Long> {

    boolean existsByNameAndLocation(String name, String location);
}