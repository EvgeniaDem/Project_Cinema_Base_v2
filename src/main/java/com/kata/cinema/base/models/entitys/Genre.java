package com.kata.cinema.base.models.entitys;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "genres")
public class Genre {

    @Id
    @SequenceGenerator(name = "gen_genres")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_genres")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    public Genre(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genre genres = (Genre) o;
        return id != null && Objects.equals(id, genres.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
