package com.example.weather.model;
// package com.weather.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private String name;
    private double temperature;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
    private String weatherMain;
    private String weatherDescription;
    private String weatherIcon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
     public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }


    @JsonProperty("main")
    private void unpackMain(Map<String, Object> main) {
        this.temperature = ((Number) main.get("temp")).doubleValue();
        this.feelsLike = ((Number) main.get("feels_like")).doubleValue();
        this.tempMin = ((Number) main.get("temp_min")).doubleValue();
        this.tempMax = ((Number) main.get("temp_max")).doubleValue();
        this.pressure = ((Number) main.get("pressure")).intValue();
        this.humidity = ((Number) main.get("humidity")).intValue();
    }

    @JsonProperty("weather")
    private void unpackWeather(List<Map<String, Object>> weather) {
        if (weather != null && !weather.isEmpty()) {
            Map<String, Object> weatherData = weather.get(0);
            this.weatherMain = (String) weatherData.get("main");
            this.weatherDescription = (String) weatherData.get("description");
            this.weatherIcon = (String) weatherData.get("icon");

        }
    }
}

