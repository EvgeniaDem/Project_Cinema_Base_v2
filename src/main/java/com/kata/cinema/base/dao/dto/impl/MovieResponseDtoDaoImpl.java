package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.entitys.Genre;
import com.kata.cinema.base.models.enums.СollectionSortType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MovieResponseDtoDaoImpl implements MovieResponseDtoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<MovieResponseDto> getMovieDto() {

//        String order;
//        switch ((СollectionSortType)parameters.get("collectionSortType")) {
//            case COUNT_SCORE: {
//                order = " order by countScore desc";
//                break;
//            }
//            case RELEASE_DATE: {
//                order = " order by m.dateRelease";
//                break;
//            }
//            case NAME: {
//                order = " order by m.name";
//                break;
//            }
//            case RATING: {
//
//            }
//            default: {
//                order = " order by avgScore desc";
//            }
//        }


        return entityManager.createQuery("SELECT  new MovieResponseDto(m.id, m.name, m.origin_name as originalName, m.time, m.date_release as dateRelease, " +
                        "m.countries, g.name as genres, p.name as director, mp.type_person as roles, avg(s.score) as avgScore)" +
                        "From movies m\n" +
                        "Join genres g ON m.id = g.id\n" +
                        "JOIN movie_person mp ON m.id = mp.movie_id\n" +
                        "JOIN professions p ON p.id = mp.profession_id\n" +
                        "JOIN score s ON m.id = s.movie_id\n" +
                        "group by mp.type_person, p.name, g.name, m.countries, m.date_release, m.time, m.origin_name, m.name, m.id" , MovieResponseDto.class)
                .getResultList();
    }
}
