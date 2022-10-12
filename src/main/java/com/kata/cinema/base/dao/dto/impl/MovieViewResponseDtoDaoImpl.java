package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieViewResponseDtoDao;
import com.kata.cinema.base.models.dto.response.CastResponseDto;
import com.kata.cinema.base.models.dto.response.MoviePersonResponseDto;
import com.kata.cinema.base.models.dto.response.MovieViewResponseDto;
import com.kata.cinema.base.models.entitys.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class MovieViewResponseDtoDaoImpl implements MovieViewResponseDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MovieViewResponseDto getMovieViewResponse(long id, User user) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.MovieViewResponseDto(" +
                        "m.id, m.name, m.originalName, m.countries, m.dateRelease, m.rars, m.mpaa, m.description," +
                        "cast(:previewUrl as java.lang.String), cast(:genres as java.lang.String)," +
                        "(select cast(avg(sc.score) as double) from Score sc where sc.movie.id = :id), (select cast(count(sc) as int) from Score sc where sc.movie.id = :id)," +
                        "(select cast(sc.score as int) from Score sc where (:userId is not null and sc.user.id = :userId) and (sc.movie.id = :id))" +
                        ") from Movie m where m.id = :id", MovieViewResponseDto.class)
                .setParameter("id", id)
                .setParameter("userId", user != null ? user.getId() : null)
                .setParameter("previewUrl", concatPreviewUrl(id).collect(Collectors.joining(" | ")))
                .setParameter("genres", concatGenres(id).collect(Collectors.joining(" | ")))
                .getSingleResult();
    }

    @Override
    public List<CastResponseDto> getCastResponse(long id) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.CastResponseDto(" +
                        "mv.id.movieId,cast(mv.id.professionId as java.lang.String), cast(pr.name as java.lang.String)" +
                        ") from MoviePerson mv join mv.movie m join mv.professions pr where m.id = :id", CastResponseDto.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<MoviePersonResponseDto> getMoviePerson(long id) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.MoviePersonResponseDto(" +
                        "cast(mv.id.professionId as java.lang.String), mv.id.personId, concat(p.firstName, ' ', p.lastName), concat(p.originalName, ' ', p.originalLastName), mv.type, mv.nameCharacter" +
                        ") from MoviePerson mv join mv.person p where mv.movie.id = :id", MoviePersonResponseDto.class)
                .setParameter("id", id)
                .getResultList();
    }

    private Stream<String> concatPreviewUrl(long id) {
        return entityManager.createQuery("select c.previewUrl as c_prev from Collection c join c.movies m where m.id = :id", String.class)
                .setParameter("id", id)
                .getResultList().stream();
    }

    private Stream<String> concatGenres(long id) {
        return entityManager.createQuery("select g.name as g_name from Movie m join m.genres g where m.id = :id", String.class)
                .setParameter("id", id)
                .getResultList().stream();
    }
}
