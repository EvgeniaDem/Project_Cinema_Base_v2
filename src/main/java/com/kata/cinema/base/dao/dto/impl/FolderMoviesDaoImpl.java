package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.entity.FolderMoviesDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.entitys.FolderMovie;
import org.springframework.stereotype.Repository;

@Repository
public class FolderMoviesDaoImpl extends AbstractDaoImpl<Long, FolderMovie> implements FolderMoviesDao {

    @Override
    public FolderMovie findByUserId(long id) {
        return entityManager.createQuery("SELECT f from FolderMovie f where f.user.id=:id", FolderMovie.class)
                .setParameter("id", id).getSingleResult();
    }
}
