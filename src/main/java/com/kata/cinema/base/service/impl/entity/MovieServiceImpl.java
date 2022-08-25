package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.service.abstracts.model.MovieService;
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
    public List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern) {
        return movieDao.getSearchMoviesWithFilter(filterPattern);
    }
}
