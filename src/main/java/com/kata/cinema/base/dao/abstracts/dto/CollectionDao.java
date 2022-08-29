package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;

import java.util.List;


public interface CollectionDao extends AbstractDao<Long, Collections> {

    List<Collections> findCollectionByType(CollectionType collectionType);

    @Override
    boolean isExistById(Long id);
}
