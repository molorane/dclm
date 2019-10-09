package com.blessy.application.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Country implements Comparable<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "city required.")
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name="continent_id", nullable=false)
    private Continent continent;

    @Override
    public int compareTo(Country country) {
        return this.getName().compareTo(country.getName());
    }
}
