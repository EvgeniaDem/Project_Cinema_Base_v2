package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.CollectionDao;
import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.response.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.CollectionType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CollectionDaoImpl extends AbstractDaoImpl<Long, Collection> implements CollectionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CollectionResponseDto> findCollectionByType(CollectionType collectionType, User user) {

        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.CollectionResponseDto(c.name, c.previewUrl, c.movies.size, f.movies.size) " +
                        " from Collection c  left join FolderMovie f " +
                        " on c.collectionType=:type and f.category = :category and f.user.id = :userId", CollectionResponseDto.class)
                .setParameter("userId", user.getId())
                .setParameter("category", Category.VIEWED_MOVIES)
                .setParameter("type", collectionType)
                .getResultList();
    }

    @Override
    public List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.SearchCollectionDto(c.name, c.previewUrl, c.movies.size) from Collection c where lower(c.name) like lower(:filter)", SearchCollectionDto.class)
                .setParameter("filter", filterPattern + "%")
                .setMaxResults(3)
                .getResultList();
    }
}
