package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.enums.СollectionSortType;
import org.hibernate.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.*;

@Repository
public class MovieResponseDtoDaoImpl implements MovieResponseDtoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Map<Long, List<MovieResponseDto>> getMapMovieResponseValueByCollectionMoviesDtoIds(Map<String, Object> parameters, Long id) {

        Map<Long, List<MovieResponseDto>> map = new HashMap<>();

        TypedQuery<?> query = (TypedQuery<?>) entityManager.createQuery("select m.id, m.name, m.originalName , m.time, m.dateRelease, m.countries, g.name, p.name, mp.nameCharacter, c.id, " +
                "cast(count(distinct s) as int) as countScore, cast(sum(s.score) as double)/count(s) as avgScore  " +
                "from Collection c " +
                "left join c.movies m " +
                "left join m.genres g " +
                "left join MoviePerson mp on m.id = mp.id.movieId " +
                "left join mp.professions p " +
                "left join Score s on m.id = s.movie.id " + queryFilters(parameters, id) + " " +
                "group by m.id, m.name, m.originalName , m.time, m.dateRelease, m.countries, g.name, p.name, mp.nameCharacter, c.id "
                + getOrder((СollectionSortType) parameters.get("collectionSortType")));

        setParametersToQuery(query, parameters, id);

        query.unwrap(Query.class)
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

    @Override
    public String getOrder(СollectionSortType collectionSortType) {
        String order;
        switch (collectionSortType) {
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
        return order;

    }

    private void setParametersToQuery(TypedQuery<?> query, Map<String, Object> parameters, Long id) {
        if (parameters.get("id") != null) {
            query.setParameter("id", parameters.get(id));
        }
        if (parameters.get("country") != null) {
            query.setParameter("country", parameters.get("country"));
        }
        if (parameters.get("genre") != null) {
            query.setParameter("genre", parameters.get("genre"));
        }
        if (parameters.get("date") != null) {
            query.setParameter("date", parameters.get("date"));
        }

    }

    private String queryFilters(Map<String, Object> parameters, Long id) {
        StringJoiner stringJoiner = new StringJoiner(" and ", "where", " ");
        if (parameters.get("id") != null) {
            stringJoiner.add(" c.id in :id ");
        }
        if (parameters.get("country") != null) {
            stringJoiner.add(" m.countries in :country ");
        }
        if (parameters.get("genre") != null) {
            stringJoiner.add(" g.name in :genre ");
        }
        if (parameters.get("date") != null) {
            stringJoiner.add(" DATE(m.dateRelease) = DATE(:date) ");
        }
        stringJoiner.setEmptyValue("");
        return stringJoiner.toString();
    }


}

