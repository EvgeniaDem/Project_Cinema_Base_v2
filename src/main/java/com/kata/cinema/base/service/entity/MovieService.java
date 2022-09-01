package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;

import java.util.List;

public interface MovieService {

    //TODO вынести в MovieDtoService(реализацию тоже)
    List<MovieReleaseResponseDto> getReleaseFilms();

    Movies getById(Long id);
}
