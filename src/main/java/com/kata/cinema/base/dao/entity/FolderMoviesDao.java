package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.FolderMovie;

public interface FolderMoviesDao extends AbstractDao<Long, FolderMovie> {
    FolderMovie findByUserId(long id);
}
