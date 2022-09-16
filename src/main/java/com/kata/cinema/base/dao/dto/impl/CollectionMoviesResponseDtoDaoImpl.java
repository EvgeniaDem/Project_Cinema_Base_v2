package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;
import com.kata.cinema.base.models.enums.СollectionSortType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class CollectionMoviesResponseDtoDaoImpl extends AbstractDaoImpl<Long, Collection> implements CollectionMoviesResponseDtoDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CollectionMoviesResponseDto> getItemsDto(Map<String, Object> parameters) {

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

        List<CollectionMoviesResponseDto> dtos = entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto" +
                        "(c.id, c.name, c.description, c.previewUrl, cast(count(distinct s) as int) as countScore, cast(sum(s.score) as double)/count(s) as avgScore) " +
                        "from Collection c left join c.movies m join m.genres g join Score s  where (select count(si) from Score si where si.movie.id = m.id)" +
                        "and (g.name in (:name) or :genreId is null) " +
                        "and (m.dateRelease in (:dateRelease) or :dateRekease is null)" +
                        "and (m.countries in (:countries) or :countries is null) group by m.id, c.id" + order, CollectionMoviesResponseDto.class)
                .setParameter("countries", parameters.get("countries"))
                .setParameter("name", parameters.get("name"))
                .setParameter("dateRelease", parameters.get("dateRelease"))
                .getResultList();

        return dtos;
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(distinct c) " +
                        "from Collection c " +
                        "left join Movie m " +
                        "on c.id = c.movies.id " +
                        "left join Score s on m.id = s.movie.id join m.genres g" +
                        "where (select count(si) from Score si where si.movie.id = m.id) and (g.name in (:name) or :genreId is null) " +
                        "and (m.dateRelease in (:dateRelease) or :dateRekease is null) " +
                        "and (m.countries in (:countries) or :countries is null) ", Long.class)
                .setParameter("countries", parameters.get("countries"))
                .setParameter("name", parameters.get("name"))
                .setParameter("dateRelease", parameters.get("dateRelease"))
                .getSingleResult();
    }
}
