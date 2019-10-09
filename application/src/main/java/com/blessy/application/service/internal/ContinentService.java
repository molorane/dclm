package com.blessy.application.service.internal;

import com.blessy.application.model.Continent;
import com.blessy.application.repository.ContinentRepository;
import com.blessy.application.service.IContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinentService implements IContinentService {

    private final ContinentRepository continentRepository;

    @Autowired
    public ContinentService(ContinentRepository continentRepository){
        this.continentRepository = continentRepository;
    }

    @Override
    public Continent addContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    @Override
    public Optional<Continent> findByName(String name) {
        return continentRepository.findByName(name);
    }

    @Override
    public Optional<Continent> findById(Integer id) {
        return continentRepository.findById(id);
    }

    @Override
    public List<Continent> findAll() {
        return continentRepository.findAll();
    }
}
