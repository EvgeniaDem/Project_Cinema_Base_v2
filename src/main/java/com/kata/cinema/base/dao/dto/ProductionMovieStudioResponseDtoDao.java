package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;

import java.util.List;

public interface ProductionMovieStudioResponseDtoDao {
    List<ProductionMovieStudioResponseDto> getProductionStudiosMovie(Long id);
}
