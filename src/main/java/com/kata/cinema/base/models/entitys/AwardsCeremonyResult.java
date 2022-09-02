package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class AwardsCeremonyResult {
    @Id
    @SequenceGenerator(name = "gen_awards_ceremony_result")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_awards_ceremony_result")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movies movies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "awards_ceremony_id")
    private AwardsCeremony awardsCeremony;

    private String nominationStatus;
}
