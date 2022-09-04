package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.FolderMoviesDao;
import com.kata.cinema.base.models.entitys.FolderMovie;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.FolderMoviesService;
import org.springframework.stereotype.Service;

@Service
public class FolderMoviesServiceImpl extends AbstractServiceImpl<Long, FolderMovie> implements FolderMoviesService {

    private final FolderMoviesDao folderMoviesDao;

    public FolderMoviesServiceImpl(FolderMoviesDao folderMoviesDao) {
        super(folderMoviesDao);
        this.folderMoviesDao = folderMoviesDao;
    }

    @Override
    public FolderMovie findByUserId(long id) {
        return  folderMoviesDao.findByUserId(id);
    }
}
