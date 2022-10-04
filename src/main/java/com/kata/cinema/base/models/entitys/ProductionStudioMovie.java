package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "production_studios_movies", uniqueConstraints = {@UniqueConstraint(columnNames = {"movie_id", "studio_id"})})
public class ProductionStudioMovie {
    @Id
    @SequenceGenerator(name = "gen_production_studios_movies")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_production_studios_movies")
    private Long id;

    @NotNull
    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;

    @NotNull
    @ManyToOne(targetEntity = ProductionStudio.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", insertable = false, updatable = false)
    private ProductionStudio studio;

    @NotNull
    @ManyToOne(targetEntity = StudioPerformance.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", insertable = false, updatable = false)
    private StudioPerformance performance;
}
