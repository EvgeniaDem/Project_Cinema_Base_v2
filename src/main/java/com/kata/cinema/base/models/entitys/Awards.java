package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Awards {

    @Id
    @SequenceGenerator(name = "gen_awards")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_awards")
    private Long id;

    private String name;

    private String description;

}
