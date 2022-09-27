package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.MovieViewResponseDtoDao;
import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.MovieViewResponseDtoService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class MovieViewResponseDtoServiceImpl implements MovieViewResponseDtoService {

    private final MovieViewResponseDtoDao movieViewResponseDtoDao;

    @Override
    public MovieViewResponseDto getMovieViewResponseDtoById(long id, User user) {
        return movieViewResponseDtoDao.getMovieViewResponse(id, user);
    }
}
