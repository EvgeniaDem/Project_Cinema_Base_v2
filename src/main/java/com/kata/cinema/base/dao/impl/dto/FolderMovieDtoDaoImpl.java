package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.FolderMovieDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class FolderMovieDtoDaoImpl implements FolderMovieDtoDao {

    private final EntityManager em;

    public FolderMovieDtoDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List getAllByUserId(Long userId) {
        Query query = em.createQuery("SELECT e.id, e.description, e.privacy, e.name, e.category FROM folders_movies e");
        return query.getResultList();
    }

    public FolderMovieDto getById(Long id) {
        Query query = em.createQuery("SELECT new com.kata.cinema.base.models.dto.FolderMovieDto(a.id, a.category, a.privacy, a.name, a.description) FROM folders_movies a WHERE a.id = :id");
        query.setParameter("id", id);
        return (FolderMovieDto) query.getSingleResult();
    }
}
