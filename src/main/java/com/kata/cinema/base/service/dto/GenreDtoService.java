package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import com.kata.cinema.base.service.entity.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreDtoService extends AbstractService<Long, Genre> {
    //TODO вынести в GenreDtoService (реализацию тоже)
    List<GenreResponseDto> findGenres();
}
