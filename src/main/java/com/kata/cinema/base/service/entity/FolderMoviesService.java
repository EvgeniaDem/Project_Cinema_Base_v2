package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.FolderMovies;

public interface FolderMoviesService  extends AbstractService<Long, FolderMovies> {

    FolderMovies findByUserId(long id);
}
