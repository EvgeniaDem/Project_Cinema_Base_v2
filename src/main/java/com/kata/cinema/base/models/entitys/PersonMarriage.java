package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "persons_marriage", uniqueConstraints = {@UniqueConstraint(columnNames = {"person_id", "human_id"})})
@Entity
public class PersonMarriage implements Serializable {

    @Id
    @SequenceGenerator(name = "gen_person_marriage")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_person_marriage")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id", referencedColumnName = "id")
    private Person human;

    @Column(name = "marriageStatus")
    private String marriageStatus;

}

