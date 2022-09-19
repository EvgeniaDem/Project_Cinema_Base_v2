package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class CollectionMoviesResponseDtoDaoImpl extends AbstractDaoImpl<Long, Collection> implements CollectionMoviesResponseDtoDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CollectionMoviesResponseDto> getItemsDto(Long id, Map<String, Object> parameters) {

        List<CollectionMoviesResponseDto> dtos = entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto " +
                        "(c.id, c.name, c.description, c.previewUrl) from Collection c where c.id in :id", CollectionMoviesResponseDto.class)
                .setParameter("id", id)
                .getResultList();
        return dtos;
    }

    @Override
    public Long getResultTotal(Long id, Map<String, Object> parameters) {
        System.out.println("это количество энтити");
        return entityManager.createQuery("select count(distinct c) from Collection c where c.id in :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Long> collectionMoviesResponseDtoIds(Long id) {
        return entityManager.createQuery("select c.id as id from Collection c where c.id = (:id)")
                .setParameter("id", id)
                .getResultList();
    }
}
