package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.CollectionDao;
import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CollectionDaoImpl extends AbstractDaoImpl<Long, Collections> implements CollectionDao {

    private EntityManager entityManager;

    public CollectionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Collections> findCollectionByType(CollectionType collectionType) {

        return entityManager.createQuery("select c from Collections c where c.collectionType=:type", Collections.class).setParameter("type", collectionType)
                .getResultList();
    }



}
