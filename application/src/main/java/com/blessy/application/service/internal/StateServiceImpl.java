package com.blessy.application.service.internal;

import com.blessy.application.model.State;
import com.blessy.application.repository.StateRepository;
import com.blessy.application.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public State addState(State state) {
        return stateRepository.save(state);
    }

    @Override
    public Optional<State> findByName(String name) {
        return stateRepository.findByName(name);
    }

    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public Optional<State> findById(Long id) {
        return stateRepository.findById(id);
    }
}
