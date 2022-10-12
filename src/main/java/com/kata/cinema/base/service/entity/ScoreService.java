package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.MovieScoreRequest;
import com.kata.cinema.base.models.MovieScoreResponse;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.models.entitys.User;

public interface ScoreService extends AbstractService<Long, Score>{
    MovieScoreResponse createRating(MovieScoreRequest request, User user);
}
