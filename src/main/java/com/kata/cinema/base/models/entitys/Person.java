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
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @SequenceGenerator(name = "gen_person")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person")
    private Long id;

    @NotNull
    private String firstName;

    private String lastName;

    private Double height;

    private Date birthday;

    @Column(name = "place_birthday")
    private String placeBirthday;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "original_last_name")
    private String originalLastName;


}






