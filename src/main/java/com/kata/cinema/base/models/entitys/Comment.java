package com.kata.cinema.base.models.entitys;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @SequenceGenerator(name = "gen_comment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_comment")
    private Long id;

    @NotNull
    private String message;

    @Column(name = "parent_id")
    private Long parentId;

    private Integer level;

    @NotNull
    private LocalDateTime date;

    @Column(name = "is_moderate")
    private Boolean isModerate = false;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "news_id")
    private News news;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
