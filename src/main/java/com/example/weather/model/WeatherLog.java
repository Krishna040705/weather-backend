package com.example.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data // Lombok annotation to generate getters, setters, etc.
public class WeatherLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private LocalDateTime searchTime;
    
    @jakarta.persistence.Column(length = 1000)
    private String weatherData; // Store the JSON response or a summary

    public WeatherLog() {
    }

    public WeatherLog(String city, String weatherData) {
        this.city = city;
        this.weatherData = weatherData;
        this.searchTime = LocalDateTime.now();
    }
}

