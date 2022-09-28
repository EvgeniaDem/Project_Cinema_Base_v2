package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.MovieTicketsDao;
import com.kata.cinema.base.models.entitys.MovieTicket;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.MovieTicketsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketsServiceImpl extends AbstractServiceImpl<Long, MovieTicket> implements MovieTicketsService {

    private final MovieTicketsDao movieTicketsDao;

    public MovieTicketsServiceImpl(AbstractDao<Long, MovieTicket> abstractDao, MovieTicketsDao movieTicketsRepository) {
        super(abstractDao);
        this.movieTicketsDao = movieTicketsRepository;
    }

    @Override
    public void addMovieTickets() {
        movieTicketsDao.addMovieTickets();
    }

    @Override
    public void deleteMovieTickets() {
        movieTicketsDao.deleteMovieTickets();
    }
}
