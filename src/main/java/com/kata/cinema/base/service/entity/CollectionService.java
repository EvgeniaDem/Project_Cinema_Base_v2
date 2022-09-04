package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.enums.CollectionType;

import java.util.List;


public interface CollectionService extends AbstractService<Long, Collection> {

    List<Collection> findCollectionByType(CollectionType collectionType);
}
