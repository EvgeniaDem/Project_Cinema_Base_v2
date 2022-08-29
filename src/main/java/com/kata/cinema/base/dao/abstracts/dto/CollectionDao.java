package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;


public interface CollectionDao extends AbstractDao<Long, Collections> {

    Collections findCollectionByType(CollectionType collectionType);

    @Override
    boolean isExistById(Long id);
}
