package com.blessy.application.service.internal;

import com.blessy.application.model.City;
import com.blessy.application.repository.CityRepository;
import com.blessy.application.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }
}
