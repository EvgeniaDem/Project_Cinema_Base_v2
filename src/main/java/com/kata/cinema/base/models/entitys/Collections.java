package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.CollectionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
    private Boolean enable;

    private String collectionUrl;

    @Enumerated(EnumType.STRING)
    private CollectionType collectionType;

    @Column(name = "previewUrl")
    private String previewUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "collections_movies",
            joinColumns = @JoinColumn(name = "collections_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    private Set<Movies> movies;

    public Collections(String name, CollectionType collectionType) {
        this.name = name;
        this.collectionType = collectionType;
        this.enable = true;
    }

    public Collections(String name, Boolean enable) {
        this.name = name;
        this.enable = enable;
    }

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


