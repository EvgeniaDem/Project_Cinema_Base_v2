package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.TypeReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @SequenceGenerator(name = "gen_review")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_review")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private TypeReview typeReview;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

}
