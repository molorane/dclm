package com.blessy.application.service;

import com.blessy.application.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    City addCity(City city);
    Optional<City> findByName(String name);
    List<City> findAll();
    Optional<City> findById(Long id);
}
