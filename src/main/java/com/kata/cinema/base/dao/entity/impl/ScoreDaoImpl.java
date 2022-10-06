package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.entitys.Score;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDaoImpl extends AbstractDaoImpl<Long, Score> implements ScoreDao {
}
