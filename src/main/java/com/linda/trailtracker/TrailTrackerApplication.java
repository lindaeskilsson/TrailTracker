package com.linda.trailtracker;

import com.linda.trailtracker.entity.Trail;
import com.linda.trailtracker.repository.TrailRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;


@SpringBootApplication
public class TrailTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrailTrackerApplication.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner initData(TrailRepository trailRepository) {
        return args -> {
            trailRepository.save(new Trail(
                    "Åreskutan runt",
                    LocalDateTime.now(),
                    10.0,
                    180,
                    350,
                    "Fin tur runt fjället, vattentäta skor behövs. Led ej spångad.",
                    "Åre"
            ));

            trailRepository.save(new Trail(
                    "Ottsjöleden",
                    LocalDateTime.now(),
                    6.0,
                    120,
                    150,
                    "Lugn och vacker led för den som vill vandra uppför i svag lutning",
                    "Ottsjö"
            ));
        };
    }


}