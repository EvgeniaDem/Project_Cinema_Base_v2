package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.dto.ScoreMovieResponseDto;
import com.kata.cinema.base.models.entitys.Score;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ScoreDaoImpl extends AbstractDaoImpl<Long, Score> implements ScoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ScoreMovieResponseDto getScoreByMovieAndUser(Long movieId, Long userId) {
        List<ScoreMovieResponseDto> resultList = entityManager.createQuery("select new com.kata.cinema.base.models.dto.ScoreMovieResponseDto(" +
                        "s.id, s.score, s.date, s.movie.id, s.user.id)" +
                        "from Score s where s.movie.id = :movieId and s.user.id = :userId", ScoreMovieResponseDto.class)
                .setParameter("movieId", movieId)
                .setParameter("userId", userId)
                .getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
