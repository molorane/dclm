package com.blessy.application.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "state")
public class State {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotEmpty(message = "State name required.")
    @Column(nullable = false, unique = true)
    private String name;

    @Getter
    @Setter
    @NotEmpty(message = "state abv required.")
    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 4, message = "State abv must have min 2 and max 4 characters.")
    private String sname;

    @ManyToOne
    @JoinColumn(name="country_id", nullable=false)
    private Country country;

}
