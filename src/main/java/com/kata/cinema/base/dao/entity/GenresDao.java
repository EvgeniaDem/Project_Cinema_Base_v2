package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genre;

import java.util.List;
import java.util.Map;

public interface GenresDao extends AbstractDao<Long, Genre> {
    Map<Long, List<String>> getAllMap();

    List<GenreResponseDto> getListOfGenres();
}
