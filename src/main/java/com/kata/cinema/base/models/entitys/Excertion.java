package com.kata.cinema.base.models.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excertion {

    @Id
    @SequenceGenerator(name = "gen_excertion")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_excertion")
    private Long id;

    @Lob
    @NotNull
    @Type(type = "org.hibernate.type.StringType")
    private String description;

    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
