package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.entitys.Score;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl extends AbstractServiceImpl<Long, Score> implements ScoreService {

    public ScoreServiceImpl(ScoreDao scoreDao) {
        super(scoreDao);
    }
}
