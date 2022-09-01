package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "movies")
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
    public LocalDate dateRelease;

    @Column(name = "rars")
    private String rars;

    @Column(name = "mpaa")
    private String mpaa;

    @Column(name = "time")
    private int time;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    Set<Genres> genres;

    private String originName;

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
