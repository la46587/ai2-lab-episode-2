package com.example.temat2.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeatherData> weatherDataList = new ArrayList<>();

    // Default constructor
    public Location() {}

    // Constructor with arguments
    public Location(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<WeatherData> getWeatherDataList() {
        return weatherDataList;
    }

    public void setWeatherDataList(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    // Helper methods for adding/removing weather data
    public void addWeatherData(WeatherData weatherData) {
        weatherDataList.add(weatherData);
        weatherData.setLocation(this);
    }

    public void removeWeatherData(WeatherData weatherData) {
        weatherDataList.remove(weatherData);
        weatherData.setLocation(null);
    }
}
