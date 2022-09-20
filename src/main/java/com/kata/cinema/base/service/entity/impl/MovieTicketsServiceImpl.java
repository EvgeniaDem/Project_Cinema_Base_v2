package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.dao.entity.MovieTicketsDao;
import com.kata.cinema.base.models.entitys.MovieTicket;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.MovieTicketsService;

public class MovieTicketsServiceImpl extends AbstractServiceImpl<Long, MovieTicket> implements MovieTicketsService {

    private final MovieTicketsDao movieTicketsDao;

    public MovieTicketsServiceImpl(AbstractDao<Long, MovieTicket> abstractDao, MovieTicketsDao movieTicketsDao) {
        super(abstractDao);
        this.movieTicketsDao = movieTicketsDao;
    }

    @Override
    public void addMovieTickets() {

    }

    @Override
    public void deleteMovieTickets() {

    }
}
