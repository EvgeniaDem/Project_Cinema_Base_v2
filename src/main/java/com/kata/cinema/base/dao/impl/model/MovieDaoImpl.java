package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MovieDaoImpl extends AbstractDaoImpl<Long, Movies> implements MovieDao {

    @Override
    public List<MovieReleaseResponseDto> getReleaseFilms() {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto(m.id, m.name, c.contentUrl, m.dateRelease) " +
                        "from Movies m join Content c on  m.id = c.movies.id where m.dateRelease > :currentDate and c.type = :type " +
                        "order by m.dateRelease", MovieReleaseResponseDto.class)
                .setParameter("currentDate", LocalDate.now())
                .setParameter("type", Type.PREVIEW)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public List<SearchMovieDto> getSearchMoviesWithFilter(String filterPattern) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.SearchMovieDto(m.id, m.name, m.originName, c.contentUrl, m.dateRelease, cast(sum(s.score) as double)/count(s) as avgScore)" +
                        " from Movies m join Content c on m.id = c.movies.id join Score s on m.id = s.movie.id where lower(m.name) like lower(:filterName) group by m.id, c.id ", SearchMovieDto.class)
                .setParameter("filterName", filterPattern + "%")
                .setMaxResults(3)
                .getResultList();
    }
}
