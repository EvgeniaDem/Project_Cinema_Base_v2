package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.dto.MovieDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDtoServiceImpl extends AbstractServiceImpl<Long, Movie> implements MovieDtoService {

    private final MovieDao movieDao;

    public MovieDtoServiceImpl(MovieDao movieDao) {
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
