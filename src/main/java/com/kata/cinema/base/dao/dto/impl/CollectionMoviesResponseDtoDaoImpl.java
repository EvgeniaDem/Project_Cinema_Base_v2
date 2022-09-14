package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import org.springframework.web.servlet.tags.form.SelectTag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CollectionMoviesResponseDtoDaoImpl implements CollectionMoviesResponseDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MovieResponseDto> getAllByMovieId(Long movieId) {
        TypedQuery<MovieResponseDto> query = entityManager.createQuery("SELECT new com.kata.cinema.base.models.dto.response.MovieResponseDto(m.id, m.name, " +
                "m.originName, m.time, m.dateRelease," +
                "m.countries, g.name, p.name, mp.type, avg(s.score)) FROM Movie m, Genre g, MoviePerson mp, Score s, Profession p", MovieResponseDto.class);
        return query.getResultList();
    }
}
