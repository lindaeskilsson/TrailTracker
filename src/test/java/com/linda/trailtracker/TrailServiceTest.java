package com.linda.trailtracker;

import com.linda.trailtracker.entity.Trail;
import com.linda.trailtracker.mapper.TrailMapper;
import com.linda.trailtracker.repository.TrailRepository;
import com.linda.trailtracker.service.TrailServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrailServiceTest {

    private final TrailRepository trailRepository = mock(TrailRepository.class);
    private final TrailMapper trailMapper = new TrailMapper();
    private final TrailServiceImpl trailService = new TrailServiceImpl(trailRepository, trailMapper);

    @Test
    void shouldReturnAllTrails() {
        Trail trail = new Trail(
                "Åreskutan",
                LocalDateTime.now(),
                10.0,
                180,
                600,
                "Fin tur",
                "Åre"
        );

        when(trailRepository.findAll()).thenReturn(List.of(trail));

        var result = trailService.getAllTrails();

        assertEquals(1, result.size());
        assertEquals("Åreskutan", result.getFirst().getName());
    }

    @Test
    void shouldReturnTrailById() {
        Trail trail = new Trail(
                "Ottsjöleden",
                LocalDateTime.now(),
                6.0,
                120,
                150,
                "Lugn led",
                "Ottsjö"
        );

        when(trailRepository.findById(1L)).thenReturn(Optional.of(trail));

        var result = trailService.getTrailDtoById(1L);

        assertEquals("Ottsjöleden", result.getName());
        assertEquals("Ottsjö", result.getLocation());
    }

    @Test
    void shouldThrowExceptionWhenTrailNotFound() {
        when(trailRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> trailService.getTrailDtoById(99L));
    }
}
