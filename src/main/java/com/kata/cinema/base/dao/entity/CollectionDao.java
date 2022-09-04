package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.enums.CollectionType;

import java.util.List;


public interface CollectionDao extends AbstractDao<Long, Collection> {

    List<Collection> findCollectionByType(CollectionType collectionType);

}
