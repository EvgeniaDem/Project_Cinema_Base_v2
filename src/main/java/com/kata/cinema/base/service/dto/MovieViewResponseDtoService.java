package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.User;

public interface MovieViewResponseDtoService {
    MovieViewResponseDto getMovieViewResponseDtoById(long id, User user);
}
