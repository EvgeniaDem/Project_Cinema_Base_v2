package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;


@Repository
public class MoviesDaoImpl extends AbstractDaoImpl<Long, Movies> implements AbstractDao<Long, Movies> {
}
