package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl extends AbstractServiceImpl<Long, Movie> implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        super(movieDao);
        this.movieDao = movieDao;
    }

    @Override
    public List<MovieReleaseResponseDto> getReleaseFilms() {
        return movieDao.getReleaseFilms();
    }

    @Override
    public List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern) {
        return movieDao.getSearchMoviesWithFilter(filterPattern);
    }
}
