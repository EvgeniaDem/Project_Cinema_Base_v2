package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.MovieDao;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.enums.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieDaoImpl extends AbstractDaoImpl<Long, Movie> implements MovieDao {

    @Override
    public List<MovieReleaseResponseDto> getReleaseFilms() {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto(m.id, m.name, c.contentUrl, m.dateRelease) " +
                        "from Movie m join Content c on  m.id = c.movie.id where m.dateRelease > :currentDate and c.type = :type " +
                        "order by m.dateRelease", MovieReleaseResponseDto.class)
                .setParameter("currentDate", LocalDate.now())
                .setParameter("type", Type.PREVIEW)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public Optional<Movie> getById(Long id) {
        return super.getById(id);
    }
}
