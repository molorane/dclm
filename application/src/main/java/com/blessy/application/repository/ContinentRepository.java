package com.blessy.application.repository;

import com.blessy.application.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

    Optional<Continent> findByName(String name);
}
