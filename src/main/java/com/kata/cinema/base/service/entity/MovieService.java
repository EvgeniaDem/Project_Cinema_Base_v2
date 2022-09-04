package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movie;

import java.util.List;

public interface MovieService {

    //TODO вынести в MovieDtoService(реализацию тоже)
    List<MovieReleaseResponseDto> getReleaseFilms();

    Movie getById(Long id);
}
