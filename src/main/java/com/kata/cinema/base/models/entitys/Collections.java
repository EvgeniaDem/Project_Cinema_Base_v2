package com.kata.cinema.base.models.entitys;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "collections")
public class Collections {

    @Id
    @SequenceGenerator(name = "gen_collections")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_collections")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "enable")
    private String enable;

    @Column(name = "previewUrl")
    private String previewUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    //TODO расписать @JoinTable
    @ToString.Exclude
    private Set<Movies> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Collections that = (Collections) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
