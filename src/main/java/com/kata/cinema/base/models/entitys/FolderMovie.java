package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "folders_movies")
@NoArgsConstructor
public class FolderMovie {
    @Id
    @SequenceGenerator(name = "gen_folder_movies")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_folder_movies")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    private String name;

    private String description;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "folders_movies_to_movies",
            joinColumns = @JoinColumn(name = "folders_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

    public FolderMovie(Long id, Category category, Privacy privacy, String name, String description) {
        this.id = id;
        this.category = category;
        this.privacy = privacy;
        this.name = name;
        this.description = description;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
