package com.blessy.application.service.internal;

import com.blessy.application.model.Country;
import com.blessy.application.repository.CountryRepository;
import com.blessy.application.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Object> geAllCountries(int continent_id) {
        return countryRepository.geAllCountries(continent_id);
    }

}
