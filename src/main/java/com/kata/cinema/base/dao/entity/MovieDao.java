package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;

import java.util.List;

public interface MovieDao extends AbstractDao<Long, Movies> {
    List<MovieReleaseResponseDto> getReleaseFilms();
}
