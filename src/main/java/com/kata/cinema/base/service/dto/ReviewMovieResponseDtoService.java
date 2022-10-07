package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.ReviewMovieResponseDto;

import java.util.Map;

public interface ReviewMovieResponseDtoService {

    ReviewMovieResponseDto getReviewMovieResponseDto(Long id, Integer pageNumber, Integer itemsOnPage, Map<String, Object> parameters);
}
