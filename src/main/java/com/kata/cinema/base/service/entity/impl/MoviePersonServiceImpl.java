package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.entitys.MoviePerson;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.MoviePersonService;
import org.springframework.stereotype.Service;

@Service
public class MoviePersonServiceImpl extends AbstractServiceImpl<Long, MoviePerson> implements MoviePersonService {

    public MoviePersonServiceImpl(AbstractDao<Long, MoviePerson> abstractDao) {
        super(abstractDao);
    }
}
