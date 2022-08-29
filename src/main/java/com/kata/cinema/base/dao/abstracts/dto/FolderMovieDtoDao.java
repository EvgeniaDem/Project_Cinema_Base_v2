package com.kata.cinema.base.dao.abstracts.dto;
import com.kata.cinema.base.models.dto.FolderMovieDto;


import java.util.List;
public interface FolderMovieDtoDao {

    List<FolderMovieDto> getAllByUserId(Long userId);

    FolderMovieDto getById(Long id);

}
