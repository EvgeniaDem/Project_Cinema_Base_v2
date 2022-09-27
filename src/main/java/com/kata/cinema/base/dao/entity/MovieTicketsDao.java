package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.MovieTicket;

public interface MovieTicketsDao extends AbstractDao<Long, MovieTicket> {
    void addMovieTickets();

    void deleteMovieTickets();

}
