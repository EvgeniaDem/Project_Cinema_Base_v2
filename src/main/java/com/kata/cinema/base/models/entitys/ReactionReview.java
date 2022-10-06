package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.TypeRating;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reaction_review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReactionReview {

    @Id
    @SequenceGenerator(name = "gen_reaction_review")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_reaction_review")
    Long id;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    TypeRating rating;

    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    Review review;

    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    public ReactionReview(Long id, TypeRating rating) {
        this.id = id;
        this.rating = rating;
    }
}
