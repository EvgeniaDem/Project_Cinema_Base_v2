package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import com.kata.cinema.base.service.dto.MovieResponseDtoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MovieResponseDtoServiceImpl implements MovieResponseDtoService {

    @Autowired
    MovieResponseDtoDao movieResponseDtoDao;


    @Override
    public List<MovieResponseDto> getMovieDto(String country, Genre genre, LocalDate date, Boolean online, Map<String, Object> parameters) {
        return movieResponseDtoDao.getMovieDto(country, genre, date, online,parameters);
    }
}
