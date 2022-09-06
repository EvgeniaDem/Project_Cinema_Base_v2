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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "score")
public class Score {
    @Id
    @SequenceGenerator(name = "gen_score")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_score")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score")
    private Long score;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Score score = (Score) o;
        return id != null && Objects.equals(id, score.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
