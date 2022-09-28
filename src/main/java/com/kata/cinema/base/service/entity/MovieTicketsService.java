package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.MovieTicket;

public interface MovieTicketsService extends AbstractService<Long, MovieTicket> {
    void addMovieTickets();

    void deleteMovieTickets();
}
