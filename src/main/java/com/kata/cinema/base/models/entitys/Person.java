package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @SequenceGenerator(name = "gen_person")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_person")
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Double height;

    private LocalDate birthday;

    @Column(name = "place_birthday")
    private String placeBirthday;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "original_last_name")
    private String originalLastName;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}






