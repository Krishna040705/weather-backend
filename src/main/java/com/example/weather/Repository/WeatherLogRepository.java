package com.example.weather.Repository;

import com.example.weather.model.WeatherLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherLogRepository extends JpaRepository<WeatherLog, Long> {
}

