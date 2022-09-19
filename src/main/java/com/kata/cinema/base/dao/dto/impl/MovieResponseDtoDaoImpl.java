package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.enums.СollectionSortType;
import org.hibernate.transform.ResultTransformer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieResponseDtoDaoImpl extends AbstractDaoImpl<Long, Movie> implements MovieResponseDtoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Map<Long, List<MovieResponseDto>> getMapMovieResponseValueByCollectionMoviesDtoIds(List<Long> collectionMoviesResponseDtoIds, Map<String, Object> parameters) {

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
        entityManager.createQuery("select m.id, m.name, m.originName as OriginalName, m.time, m.dateRelease as date, m.countries as country, g.name as genre, p.name, mp.nameCharacter as role , " +
                        "avg(s.score) as avgScore " +
                        "from Movie m " +
                        "join Genre g on (g.name in (:genre) or :genre is null) \n" +
                        "join MoviePerson mp on m.id = mp.movie.id\n" +
                        "join Profession p on p.id = mp.professions.id\n" +
                        "join Collection c on m.id = c.id join Score s on s.id = m.id " +
                        "where (m.countries in (:country) or :country is null) " +
                        "and (c.id in (:collectionMoviesResponseDtoIds) or :collectionMoviesResponseDtoIds is null) " +
                        "and (m.countries in (:country) or :country is null)" +
                        "and (c.enable in (:online) or :online is null ) " +
                        "and (m.dateRelease in (:date)) " +
                        "group by m.id, g.name, p.name, mp.nameCharacter" + order)
                .setParameter("collectionMoviesResponseDtoIds", collectionMoviesResponseDtoIds)
                .setParameter("country", parameters.get("country"))
                .setParameter("genre", parameters.get("genre"))
                .setParameter("date", parameters.get("date"))
                .setParameter("online", parameters.get("online"))
                .unwrap(org.hibernate.Query.class)
                .setResultTransformer(new ResultTransformer() {
                    @Override
                    public Object transformTuple(Object[] objects, String[] strings) {

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
                        movieResponseDto.setAvgScore((Double) objects[9]);


                        Long collectionMoviesResponseDtoId = (Long) objects[10];
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

