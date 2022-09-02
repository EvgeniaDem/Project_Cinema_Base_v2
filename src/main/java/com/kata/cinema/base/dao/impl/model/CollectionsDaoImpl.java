package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.CollectionsDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.entitys.Collections;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CollectionsDaoImpl extends AbstractDaoImpl<Collections, Long> implements CollectionsDao {

    @Override
    public List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.SearchCollectionDto(c.name, c.previewUrl, c.movies.size) from Collections c where lower(c.name) like lower(:filter)", SearchCollectionDto.class)
                .setParameter("filter", filterPattern + "%")
                .setMaxResults(3)
                .getResultList();
    }
}
