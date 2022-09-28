package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "movie_tickets")
public class MovieTicket {

    @Id
    @SequenceGenerator(name = "gen_movie_tickets")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_movie_tickets")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "end_show_date")
    private LocalDate endShowDate;

    public MovieTicket(Movie movie, LocalDate endShowDate) {
        this.movie = movie;
        this.endShowDate = endShowDate;
    }
}
