package com.blessy.application.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Continent name required.")
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy="continent", fetch = FetchType.LAZY)
    private Collection<Country> countries = new HashSet<>();
}
