package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieResponseDtoDaoImpl extends AbstractDaoImpl<Long, Movie> implements MovieResponseDtoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Map<Long, List<MovieResponseDto>> getAllCollections() {
        List<Object[]> collectionMoviesResponseDtos = entityManager.createQuery("select c.id, c.name, c.description, c.previewUrl," +
                        "m.id, m.name, m.originName, m.dateRelease, m.countries, g.name, p.name, mp.type, avg(s.score) from Collection c left join c.movies m join m.genres g on m.id = g.id " +
                        "join MoviePerson mp  join mp.professions p on p.id = m.id join Score s on m.id = s.id")
                .getResultList();
        Map<Long, List<MovieResponseDto>> movieResponseDtoMap = new HashMap<>();
        for (Object[] o : collectionMoviesResponseDtos) {
            if (movieResponseDtoMap.get(o[0]) == null) {
                movieResponseDtoMap.put((Long) o[0], new ArrayList<>());
            }
            movieResponseDtoMap.get(o[0]).add((MovieResponseDto) o[1]);
        }
        return movieResponseDtoMap;
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

