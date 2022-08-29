package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.FolderMovies;

public interface FolderMoviesService {

    FolderMovies findByUserId(long id);
}
