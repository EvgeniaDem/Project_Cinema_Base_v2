package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class News {

    @Id
    @SequenceGenerator(name = "gen_news")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_news")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Rubric rubric;

    @NotNull
    private LocalDate date;

    @NotNull
    private String title;

    @NotNull
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String htmlBody;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "news_movie",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
