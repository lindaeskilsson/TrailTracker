package com.linda.trailtracker;

import com.linda.trailtracker.dto.CreateTrailDto;
import com.linda.trailtracker.dto.TrailDto;
import com.linda.trailtracker.dto.UpdateTrailDto;
import com.linda.trailtracker.entity.Trail;
import com.linda.trailtracker.mapper.TrailMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TrailMapperTest {

    private final TrailMapper mapper = new TrailMapper();

    @Test
    void shouldConvertEntityToDto() {
        Trail trail = new Trail(
                "Åreskutan",
                LocalDateTime.now(),
                10.0,
                180,
                600,
                "Fin tur",
                "Åre"
        );

        TrailDto dto = mapper.toDto(trail);

        assertEquals("Åreskutan", dto.getName());
        assertEquals(10.0, dto.getDistanceKm());
        assertEquals(180, dto.getTimeMinutes());
        assertEquals(600, dto.getElevationGain());
        assertEquals("Fin tur", dto.getDescription());
        assertEquals("Åre", dto.getLocation());
    }

    @Test
    void shouldConvertCreateDtoToEntity() {
        CreateTrailDto dto = new CreateTrailDto();
        dto.setName("Ottsjöleden");
        dto.setDistanceKm(6.0);
        dto.setTimeMinutes(120);
        dto.setElevationGain(150);
        dto.setDescription("Lugn led");
        dto.setLocation("Ottsjö");

        Trail trail = mapper.toEntity(dto);

        assertEquals("Ottsjöleden", trail.getName());
        assertEquals(6.0, trail.getDistanceKm());
        assertEquals(120, trail.getTimeMinutes());
        assertEquals(150, trail.getElevationGain());
        assertEquals("Lugn led", trail.getDescription());
        assertEquals("Ottsjö", trail.getLocation());
    }

    @Test
    void shouldUpdateExistingEntityFromUpdateDto() {
        Trail trail = new Trail(
                "Gammalt namn",
                LocalDateTime.now(),
                5.0,
                90,
                100,
                "Gammal beskrivning",
                "Åre"
        );

        UpdateTrailDto dto = new UpdateTrailDto();
        dto.setName("Nytt namn");
        dto.setDistanceKm(8.0);
        dto.setTimeMinutes(140);
        dto.setElevationGain(300);
        dto.setDescription("Ny beskrivning");
        dto.setLocation("Ottsjö");

        mapper.updateEntity(dto, trail);

        assertEquals("Nytt namn", trail.getName());
        assertEquals(8.0, trail.getDistanceKm());
        assertEquals(140, trail.getTimeMinutes());
        assertEquals(300, trail.getElevationGain());
        assertEquals("Ny beskrivning", trail.getDescription());
        assertEquals("Ottsjö", trail.getLocation());
    }
}