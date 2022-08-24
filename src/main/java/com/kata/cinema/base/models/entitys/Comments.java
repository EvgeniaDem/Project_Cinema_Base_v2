package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Comments")
public class Comments {
    @Id
    @SequenceGenerator(name = "gen_comment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_comment")
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    @NotNull
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private News news;

}
