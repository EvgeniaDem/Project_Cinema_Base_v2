package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Proxy(lazy = false)
@Table(name = "studios_performance")
public class StudioPerformance {
    @Id
    @SequenceGenerator(name = "gen_studios_performance")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_studios_performance")
    private Long id;

    @NotNull
    private String name;
}
