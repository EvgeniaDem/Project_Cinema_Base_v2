package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;

import java.util.List;
import java.util.Map;

public interface GenresDao extends AbstractDao<Long, Genres> {
    Map<Long, List<String>> getAllMap();

    List<GenreResponseDto> getListOfGenres();
}
