package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.entitys.FolderMovies;

public interface FolderMoviesDao extends AbstractDao<Long, FolderMovies> {

    FolderMovies findByUserId(long id);
}
