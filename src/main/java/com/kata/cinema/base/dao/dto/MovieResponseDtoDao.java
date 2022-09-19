package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.MovieResponseDto;

import java.util.List;
import java.util.Map;

public interface MovieResponseDtoDao {
    Map<Long, List<MovieResponseDto>> getMapMovieResponseValueByCollectionMoviesDtoIds(List<Long> collectionMoviesResponseDtoIds, Map<String, Object> parameters);
}
