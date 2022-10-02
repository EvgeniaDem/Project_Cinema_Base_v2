package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "production_studios")
public class ProductionStudio {
    @Id
    @SequenceGenerator(name = "gen_productions_studios")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_productions_studios")
    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    @Column(name = "date_foundation")
    private LocalDate dateFoundation;
}
