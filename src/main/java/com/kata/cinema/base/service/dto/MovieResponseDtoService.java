package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;

import java.util.Map;

public interface MovieResponseDtoService {
   PageDto<CollectionMoviesResponseDto> getPageDto(Map<String, Object> parameters);
}
