package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService extends AbstractService<Long, Genre> {
    //TODO вынести в GenreDtoService (реализацию тоже)
    List<GenreResponseDto> findGenres();
}
