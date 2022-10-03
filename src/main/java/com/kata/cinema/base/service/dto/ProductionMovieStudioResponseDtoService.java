package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;

import java.util.List;

public interface ProductionMovieStudioResponseDtoService {
    List<ProductionMovieStudioResponseDto> getProductionStudiosMovie(Long id);
}
