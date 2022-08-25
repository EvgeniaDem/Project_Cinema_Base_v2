package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;

import java.util.List;

public interface MovieDao extends AbstractDao<Long, Movies> {
    List<MovieReleaseResponseDto> getReleaseFilms();

    List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern);
}
