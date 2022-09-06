package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.FolderMovie;

public interface FolderMoviesService  extends AbstractService<Long, FolderMovie> {

    FolderMovie findByUserId(long id);
}
