package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.MovieResponseDto;

import java.util.List;

public interface CollectionMoviesResponseDtoDao {
    List<MovieResponseDto> getAllByMovieId(Long movieId);
}
