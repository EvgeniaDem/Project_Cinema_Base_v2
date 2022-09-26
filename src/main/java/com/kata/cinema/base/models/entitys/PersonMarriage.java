package com.kata.cinema.base.models.entitys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import javax.persistence.UniqueConstraint;
import java.io.Serializable;


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

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id", referencedColumnName = "id")
    private Person human;

    @Column(name = "marriageStatus")
    private String marriageStatus;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

