package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.service.entity.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<MovieReleaseResponseDto> getReleaseFilms() {
        return movieDao.getReleaseFilms();
    }

    @Override
    public Movies getById(Long id) {
        return movieDao.getById(id).orElse(null);

    }


}
