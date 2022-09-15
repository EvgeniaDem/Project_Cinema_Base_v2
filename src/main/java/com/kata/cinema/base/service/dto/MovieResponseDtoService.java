package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Genre;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MovieResponseDtoService {
   PageDto<CollectionMoviesResponseDto> getPageDto(Map<String, Object> parameters);
}
