package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;

import java.util.List;

public interface MovieService {


    List<MovieReleaseResponseDto> getReleaseFilms();
    List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern);
    Movies getById(Long id);

}
