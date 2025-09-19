package com.example.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.weather.model.WeatherLog;
import com.example.weather.model.WeatherResponse;
import com.example.weather.Repository.WeatherLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherLogRepository weatherLogRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherResponse getWeatherByCity(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response != null) {
            try {
                // Convert the response object to a JSON string to store in the database
                ObjectMapper objectMapper = new ObjectMapper();
                String weatherData = objectMapper.writeValueAsString(response);
                
                WeatherLog log = new WeatherLog(city, weatherData);
                weatherLogRepository.save(log);
            } catch (JsonProcessingException e) {
                // Handle the exception, e.g., log an error
                e.printStackTrace();
            }
        }
        return response;
    }

    public List<WeatherLog> getSearchHistory() {
        return weatherLogRepository.findAll();
    }
}

