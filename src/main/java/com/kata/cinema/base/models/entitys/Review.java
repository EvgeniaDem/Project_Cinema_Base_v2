package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.TypeReview;
import lombok.*;

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

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Movie movie;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
