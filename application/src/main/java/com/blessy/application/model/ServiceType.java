package com.blessy.application.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Service type name required.")
    private String name;

    @NotEmpty(message = "Service type name abbreviation required.")
    @Size(max = 3, message = "Characters must not exceed 3.")
    private String abv;
}
