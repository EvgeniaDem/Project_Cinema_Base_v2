package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.service.entity.AbstractService;

import java.util.List;

public interface MovieDtoService extends AbstractService<Long, Movie> {

    List<MovieReleaseResponseDto> getReleaseFilms();

    List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern);
}
