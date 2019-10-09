package com.blessy.application.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "continent")
@Getter
@Setter
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Continent required.")
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy="continent", fetch = FetchType.EAGER)
    private List<Country> countries = new ArrayList<>();;
}
