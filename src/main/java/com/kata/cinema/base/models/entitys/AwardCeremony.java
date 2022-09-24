package com.kata.cinema.base.models.entitys;

import lombok.EqualsAndHashCode;
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
@Table(name = "awards_ceremony")
@Setter
@Getter
@NoArgsConstructor
public class AwardCeremony {

    @Id
    @SequenceGenerator(name = "gen_awards_ceremony")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_awards_ceremony")
    private Long id;

    private String dateEvent;

    private String placeEvent;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "awards_id")
    private Award awards;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
