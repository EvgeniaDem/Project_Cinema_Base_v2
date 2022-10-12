package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.ScoreMovieResponseDto;
import com.kata.cinema.base.models.entitys.Score;

public interface ScoreDao extends AbstractDao<Long, Score>{
    ScoreMovieResponseDto getScoreByMovieAndUser(Long movieId, Long userId);
}
