package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.User;

public interface MovieViewResponseDtoDao {
    MovieViewResponseDto getMovieViewResponse(long id, User user);
}
