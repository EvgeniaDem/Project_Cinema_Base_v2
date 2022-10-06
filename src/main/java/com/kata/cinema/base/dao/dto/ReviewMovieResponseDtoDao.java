package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.ReviewMovieResponseDto;

public interface ReviewMovieResponseDtoDao {
    ReviewMovieResponseDto getReviewMovieResponseDto(Long id);
}
