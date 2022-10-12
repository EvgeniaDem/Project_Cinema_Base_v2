package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.dto.ScoreMovieResponseDto;
import com.kata.cinema.base.models.entitys.Score;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ScoreDaoImpl extends AbstractDaoImpl<Long, Score> implements ScoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ScoreMovieResponseDto getScoreByMovieAndUser(Long movieId, Long userId) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.ScoreMovieResponseDto(" +
                        "s.id, s.score,)" +

                        "from Score s where s.movie =: movieId and s.user =: userId", ScoreMovieResponseDto.class)
                //.setParameter("id", movieId)
                .setParameter("movie", movieId)
                .setParameter("user", userId)
                .getSingleResult();
    }
}
