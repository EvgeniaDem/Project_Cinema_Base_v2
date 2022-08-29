package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;

import java.util.List;


public interface CollectionService extends AbstractService<Long, Collections> {

    List<Collections> findCollectionByType(CollectionType collectionType);


}
