package com.blessy.application.service;

import com.blessy.application.model.ServiceType;

import java.util.List;
import java.util.Optional;

public interface ServiceTypeService {

    ServiceType addServiceType(ServiceType serviceType);
    Optional<ServiceType> findByName(String name);
    Optional<ServiceType> findById(Long id);
    List<ServiceType> findAll();
    ServiceType editServiceType(ServiceType serviceType);
}
