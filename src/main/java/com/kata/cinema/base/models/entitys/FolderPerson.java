package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Privacy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "folders_persons")
public class FolderPerson {

    @Id
    @SequenceGenerator(name = "gen_folder_person")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_folder_person")
    private Long id;

    private Boolean favourites;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "folder_persons_to_person",
            joinColumns = @JoinColumn(name = "folders_persons_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> person;

}
