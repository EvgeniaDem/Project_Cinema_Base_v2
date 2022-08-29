package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.FolderMoviesDao;
import com.kata.cinema.base.models.entitys.FolderMovies;
import com.kata.cinema.base.service.abstracts.model.FolderMoviesService;
import org.springframework.stereotype.Service;

@Service
public class FolderMoviesServiceImpl implements FolderMoviesService {

    private FolderMoviesDao folderMoviesDao;

    public FolderMoviesServiceImpl(FolderMoviesDao folderMoviesDao) {
        this.folderMoviesDao = folderMoviesDao;
    }

    @Override
    public FolderMovies findByUserId(long id) {
        return  folderMoviesDao.findByUserId(id);
    }
}
