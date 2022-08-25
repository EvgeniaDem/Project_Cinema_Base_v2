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
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.SearchMovieDto(m.id, m.name, m.originName) from Movies m where lower(m.name) like lower(:filterName)", SearchMovieDto.class)
                .setParameter("filterName", filterPattern +"%").getResultList();
//                .setMaxResults(3)
//                .getResultList();
//TODO уточнить по поводу полей который нету в movies но есть в SearchMovieDto
//        and m.originalName = c.movies.originName and m.previeUrl = c.movies.description and m.date = c.movies.dateRelease and m.avgScore = c.movies.mpaa
    }
}
