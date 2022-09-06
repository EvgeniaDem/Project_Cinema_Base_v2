package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.FolderMovieDto;

import java.util.List;

public interface FolderMovieDtoService {

    List<FolderMovieDto> getAllByUserId(Long userId);

    FolderMovieDto getById(Long id);
}
