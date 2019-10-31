package com.blessy.application.service;

import com.blessy.application.model.State;

import java.util.List;
import java.util.Optional;

public interface StateService {

    State addState(State state);
    Optional<State> findByName(String name);
    List<State> findAll();
    Optional<State> findById(Long id);
}
