package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.CollectionDao;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.enums.CollectionType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CollectionDaoImpl extends AbstractDaoImpl<Long, Collection> implements CollectionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Collection> findCollectionByType(CollectionType collectionType) {

        return entityManager.createQuery("select c from Collection c where c.collectionType=:type", Collection.class).setParameter("type", collectionType)
                .getResultList();
    }
}
