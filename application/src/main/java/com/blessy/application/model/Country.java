package com.blessy.application.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "country required.")
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name="continent_id", nullable=false)
    private Continent continent;

    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<State> states = new ArrayList<>();

}
