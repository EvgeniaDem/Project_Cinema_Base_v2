package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.MovieScoreRequest;
import com.kata.cinema.base.models.MovieScoreResponse;
import com.kata.cinema.base.models.dto.ScoreMovieResponseDto;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.MovieDtoService;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Slf4j
public class ScoreServiceImpl extends AbstractServiceImpl<Long, Score> implements ScoreService {

    private final ScoreDao scoreDao;
    private final MovieDtoService movieDtoService;
    private final MovieDao movieDao;

    public ScoreServiceImpl(ScoreDao scoreDao, MovieDao movieDao, MovieDtoService movieDtoService) {
        super(scoreDao);
        this.scoreDao = scoreDao;
        this.movieDao = movieDao;
        this.movieDtoService = movieDtoService;
    }

    @Transactional
    @Override
    public MovieScoreResponse createRating(MovieScoreRequest request, User user) {

        MovieScoreResponse response = new MovieScoreResponse();
        response.setMovieId(request.getMovieId());
        response.setUserId(user.getId());

        Long movieId = request.getMovieId();
        Long userId = user.getId();
        if (!movieDtoService.isExistById(movieId)) {
            response.setCreated(false);
            response.setMessage("Такого фильма не существует");
        } else {
            ScoreMovieResponseDto dto = scoreDao.getScoreByMovieAndUser(movieId, userId);
            if (dto == null) {
                Score newScore = new Score();
                newScore.setScore(request.getScore());
                newScore.setDate(LocalDate.now());
                newScore.setMovie(movieDao.getById(movieId).get());
                newScore.setUser(user);
                scoreDao.create(newScore);
                response.setCreated(true);
                response.setMessage("Оценка успешно создана");
            } else {
                response.setCreated(false);
                response.setMessage("Пользователь уже ставил оценку");
                log.warn("Score already exists: {}", dto);
            }
        }
        return response;
    }
}
