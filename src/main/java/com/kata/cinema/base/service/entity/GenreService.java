package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService extends AbstractService<Long, Genres> {
    //TODO вынести в GenreDtoService (реализацию тоже)
    List<GenreResponseDto> findGenres();
}
