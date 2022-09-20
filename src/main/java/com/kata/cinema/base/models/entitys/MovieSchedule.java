package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.FormatType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "movie_schedule")
public class MovieSchedule {

    @Id
    @SequenceGenerator(name = "gen_movie_schedule")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_movie_schedule")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = MovieTicket.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_ticket_id", insertable = false, updatable = false)
    private MovieTicket movieTicket;

    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    private FormatType formatType;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "price")
    private Integer price;

}
