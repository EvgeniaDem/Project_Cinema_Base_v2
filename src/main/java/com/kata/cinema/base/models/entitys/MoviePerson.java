package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movie_person")
public class MoviePerson {

    @Getter
    @Setter
    @NoArgsConstructor
    @Embeddable
    @EqualsAndHashCode
    public static class Id implements Serializable {

        @Column(name = "person_id")
        private Long personId;

        @Column(name = "movie_id")
        private Long movieId;

        @Column(name = "profession_id")
        private Long professionId;

        public Id(Long personId, Long movieId, Long professionId) {
            this.personId = personId;
            this.movieId = movieId;
            this.professionId = professionId;
        }
    }

    @EmbeddedId
    private Id id;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @ManyToOne(targetEntity = Movies.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movies movie;

    @ManyToOne(targetEntity = Profession.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id", insertable = false, updatable = false)
    private Profession professions;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_person")
    private TypeCharacter type;

    @Column(name = "name_role")
    private String nameCharacter;
}
