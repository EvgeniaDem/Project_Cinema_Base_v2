package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Genre;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MovieResponseDtoDao {
    List<MovieResponseDto> getMovieDto();
}
