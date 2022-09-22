package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movie;

import java.util.List;

public interface MovieService extends AbstractService<Long, Movie> {

    //TODO вынести в MovieDtoService(реализацию тоже)
    List<MovieReleaseResponseDto> getReleaseFilms();

    List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern);
}
