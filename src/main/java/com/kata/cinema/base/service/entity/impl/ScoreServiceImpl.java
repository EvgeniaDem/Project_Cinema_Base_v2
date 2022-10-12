package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.MovieScoreRequest;
import com.kata.cinema.base.models.dto.ScoreMovieResponseDto;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ScoreServiceImpl extends AbstractServiceImpl<Long, Score> implements ScoreService {

    private final ScoreDao scoreDao;
    private final MovieDao movieDao;

    public ScoreServiceImpl(ScoreDao scoreDao, MovieDao movieDao) {
        super(scoreDao);
        this.scoreDao = scoreDao;
        this.movieDao = movieDao;
    }

    @Override
    public void createRating(MovieScoreRequest request, User user) {

        Long movieId = request.getMovieId();
        Long userId = user.getId();

        //ScoreMovieResponseDto dto = scoreDao.getScoreByMovieAndUser(movieId, userId);
        //if (dto == null) {
            Score newScore = new Score();
            newScore.setScore(request.getScore());
            newScore.setDate(LocalDate.now());
            newScore.setMovie(movieDao.getById(movieId).get());
            newScore.setUser(user);
            System.out.println();
            //scoreDao.create(newScore);
        //}
        //scoreDao.create(null);

        //create(new Score());
    }
}
