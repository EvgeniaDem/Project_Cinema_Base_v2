package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.enums.СollectionSortType;
import org.hibernate.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.*;

@Repository
public class MovieResponseDtoDaoImpl extends AbstractDaoImpl<Long, Movie> implements MovieResponseDtoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Map<Long, List<MovieResponseDto>> getMapMovieResponseValueByCollectionMoviesDtoIds(Map<String, Object> parameters, Long id, LocalDate date) {

        String order;
        switch ((СollectionSortType) parameters.get("collectionSortType")) {
            case COUNT_SCORE: {
                order = " order by countScore desc";
                break;
            }
            case RELEASE_DATE: {
                order = " order by m.dateRelease";
                break;
            }
            case NAME: {
                order = " order by m.name";
                break;
            }
            case RATING: {

            }
            default: {
                order = " order by avgScore desc";
            }
        }

        Map<Long, List<MovieResponseDto>> map = new HashMap<>();


        String q = "select m.id, m.name, m.originalName , m.time, m.dateRelease, m.countries, g.name, p.name, mp.nameCharacter, c.id, " +
                "cast(count(distinct s) as int) as countScore, cast(sum(s.score) as double)/count(s) as avgScore " +
                "from Collection c " +
                "left join c.movies m " +
                "left join m.genres g  " +
                "left join MoviePerson mp on m.id = mp.id.movieId  " +
                "left join mp.professions p " +
                "left join Score s on m.id = s.movie.id " +
                "where (c.id in :id) " +
                "and (g.name in :genre or :genre is null) " +
                "and (m.countries in :country or :country is null) " +
                "and (DATE(m.dateRelease) = DATE(:date) or DATE(:date) is null) " +
                "group by m.id, m.name, m.originalName , m.time, m.dateRelease, m.countries, g.name, p.name, mp.nameCharacter, c.id " + order;

        entityManager.createQuery(q)

                .setParameter("id", id)
                .setParameter("country", parameters.get("country"))
                .setParameter("genre", parameters.get("genre"))
                .setParameter("date", date)
                .unwrap(Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] objects, String[] strings) {
                        Long collectionMoviesResponseDtoId = ((Long) objects[9]);

                        MovieResponseDto movieResponseDto = new MovieResponseDto();
                        movieResponseDto.setId((Long) objects[0]);
                        movieResponseDto.setName((String) objects[1]);
                        movieResponseDto.setOriginalName((String) objects[2]);
                        movieResponseDto.setTime((Integer) objects[3]);
                        movieResponseDto.setDateRelease((LocalDate) objects[4]);
                        movieResponseDto.setCountries((String) objects[5]);
                        movieResponseDto.setGenres((String) objects[6]);
                        movieResponseDto.setDirector((String) objects[7]);
                        movieResponseDto.setRoles((String) objects[8]);

                        if (!map.containsKey(collectionMoviesResponseDtoId)) {
                            map.put(collectionMoviesResponseDtoId, new ArrayList<>());
                        }
                        map.get(collectionMoviesResponseDtoId).add(movieResponseDto);

                        return objects;
                    }

                    @Override
                    public List transformList(List list) {
                        return list;
                    }
                }).getResultList();
        return map;
    }
}

