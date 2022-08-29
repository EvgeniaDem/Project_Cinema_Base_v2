package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovieDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderMovieDtoServiceImpl implements FolderMovieDtoService {

    private final FolderMovieDtoDao folderMovieDtoDao;

    public FolderMovieDtoServiceImpl(FolderMovieDtoDao folderMovieDtoDao) {
        this.folderMovieDtoDao = folderMovieDtoDao;
    }

    @Override
    public List<FolderMovieDto> getAllByUserId(Long userId) {
        return folderMovieDtoDao.getAllByUserId(userId);
    }

    @Override
    public FolderMovieDto getById(Long id) {
        return folderMovieDtoDao.getById(id);
    }

}
