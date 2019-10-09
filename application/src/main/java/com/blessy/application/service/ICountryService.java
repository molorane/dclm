package com.blessy.application.service;

import com.blessy.application.model.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {

    Country addCountry(Country continent);
    Optional<Country> findByName(String name);
    List<Country> findAll();
}
