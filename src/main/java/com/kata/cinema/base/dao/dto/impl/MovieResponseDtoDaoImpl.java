package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
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
    public Map<Long, List<MovieResponseDto>> getMapMovieResponseValueByCollectionMoviesDtoIds(List<Long> collectionMoviesResponseDtoIds) {
        System.out.println("это мапа");
        Map<Long, List<MovieResponseDto>> map = new HashMap<>();
        entityManager.createQuery("select c.id, c.name, c.description, c.previewUrl, m.id, m.name, m.originName, m.time, m.dateRelease,  m.countries,  g.name, " +
                        "p.name, mp.nameCharacter , avg(s.score) \n" +
                        "from Collection  c \n" +
                        "left join c.movies m on c.id = m.id \n" +
                        "join m.genres g on m.id=g.id\n" +
                        "join Score s on m.id = s.movie.id\n" +
                        "join MoviePerson mp on mp.movie.id = m.id\n" +
                        "join mp.professions p on mp.professions.id = p.id where c.id in :collectionMoviesResponseDtoIds group by c.id, m.id, g.id, p.id, mp.id ")
                .setParameter("collectionMoviesResponseDtoIds", collectionMoviesResponseDtoIds)
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

//    @Override
//    public List<MovieResponseDto> getMovieDto() {
//
////        String order;
////        switch ((СollectionSortType)parameters.get("collectionSortType")) {
////            case COUNT_SCORE: {
////                order = " order by countScore desc";
////                break;
////            }
////            case RELEASE_DATE: {
////                order = " order by m.dateRelease";
////                break;
////            }
////            case NAME: {
////                order = " order by m.name";
////                break;
////            }
////            case RATING: {
////
////            }
////            default: {
////                order = " order by avgScore desc";
////            }
////        }
//
//
//        return entityManager.createQuery("SELECT  new MovieResponseDto(m.id, m.name, m.origin_name as originalName, m.time, m.date_release as dateRelease, " +
//                        "m.countries, g.name as genres, p.name as director, mp.type_person as roles, avg(s.score) as avgScore)" +
//                        "From movies m\n" +
//                        "Join genres g ON m.id = g.id\n" +
//                        "JOIN movie_person mp ON m.id = mp.movie_id\n" +
//                        "JOIN professions p ON p.id = mp.profession_id\n" +
//                        "JOIN score s ON m.id = s.movie_id\n" +
//                        "group by mp.type_person, p.name, g.name, m.countries, m.date_release, m.time, m.origin_name, m.name, m.id" , MovieResponseDto.class)
//                .getResultList();
//    }

