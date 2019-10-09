package com.blessy.application.service;

import com.blessy.application.model.Continent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IContinentService {

    Continent addContinent(Continent continent);
    Optional<Continent> findByName(String name);
    Optional<Continent> findById(Integer id);
    List<Continent> findAll();
}
