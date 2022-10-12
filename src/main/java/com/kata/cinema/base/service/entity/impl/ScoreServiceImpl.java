package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.MovieScoreRequest;
import com.kata.cinema.base.models.dto.ScoreMovieResponseDto;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.models.entitys.User;
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
    private final MovieDao movieDao;

    public ScoreServiceImpl(ScoreDao scoreDao, MovieDao movieDao) {
        super(scoreDao);
        this.scoreDao = scoreDao;
        this.movieDao = movieDao;
    }

    @Transactional
    @Override
    public void createRating(MovieScoreRequest request, User user) {

        Long movieId = request.getMovieId();
        Long userId = user.getId();

        ScoreMovieResponseDto dto = scoreDao.getScoreByMovieAndUser(movieId, userId);
        if (dto == null) {
            Score newScore = new Score();
            newScore.setScore(request.getScore());
            newScore.setDate(LocalDate.now());
            newScore.setMovie(movieDao.getById(movieId).get());
            newScore.setUser(user);
            System.out.println();
            scoreDao.create(newScore);
        } else {
            log.warn("Score already exists: {}", dto);
        }
        //scoreDao.create(null);

        //create(new Score());
    }
}
