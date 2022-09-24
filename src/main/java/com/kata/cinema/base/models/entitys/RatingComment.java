package com.kata.cinema.base.models.entitys;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rating_comment")
public class RatingComment {
    @Id
    @SequenceGenerator(name = "gen_rating_comment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_rating_comment")
    private Long id;

    @Range(min = -1, max = 1)
    private Integer rating;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
