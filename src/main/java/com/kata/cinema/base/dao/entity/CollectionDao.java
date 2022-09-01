package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;

import java.util.List;


public interface CollectionDao extends AbstractDao<Long, Collections> {

    List<Collections> findCollectionByType(CollectionType collectionType);

}
