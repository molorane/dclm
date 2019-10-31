package com.blessy.application.service;

import com.blessy.application.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country addCountry(Country continent);
    Optional<Country> findByName(String name);
    List<Country> findAll();
    Optional<Country> findById(Long id);
}
