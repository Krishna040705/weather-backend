package com.example.weather.controller;

import com.example.weather.model.WeatherLog;
import com.example.weather.model.WeatherResponse;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*") // Allows all origins for simplicity in development
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        WeatherResponse weatherData = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(weatherData);
    }

    @GetMapping("/history")
    public ResponseEntity<List<WeatherLog>> getHistory() {
        List<WeatherLog> history = weatherService.getSearchHistory();
        return ResponseEntity.ok(history);
    }
}

