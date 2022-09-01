package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.FolderMovieDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class FolderMovieDtoDaoImpl implements FolderMovieDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<FolderMovieDto> getAllByUserId(Long userId) {
        TypedQuery<FolderMovieDto> query = entityManager.createQuery("SELECT new com.kata.cinema.base.models.dto.FolderMovieDto(fm.id, fm.category, fm.privacy, fm.name, fm.description) FROM FolderMovies fm", FolderMovieDto.class);
        return query.getResultList();
    }

    public FolderMovieDto getById(Long id) {
        TypedQuery<FolderMovieDto> query = entityManager.createQuery("SELECT new com.kata.cinema.base.models.dto.FolderMovieDto(fm.id, fm.category, fm.privacy, fm.name, fm.description) FROM FolderMovies fm WHERE fm.id = :id", FolderMovieDto.class);
        query.setParameter("id", id);
        return (FolderMovieDto) query.getSingleResult();
    }
}
