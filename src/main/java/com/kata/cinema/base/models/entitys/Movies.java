package com.kata.cinema.base.models.entitys;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="movies")
public class Movies {

    @Id
    @SequenceGenerator(name = "gen_movies")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_movies")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "countries")
    public String countries;

    @Column(name = "dateRelease")
    public Long dateRelease;

    @Column(name = "rars")
    private int rars;

    @Column(name = "mpaa")
    private int mpaa;

    @Column(name = "time")
    private int time;

    @Column(name = "desciption")
    private String desciption;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movies movies = (Movies) o;
        return id != null && Objects.equals(id, movies.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
