package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;


public interface CollectionService extends AbstractService<Long, Collections> {

    Collections findCollectionByType(CollectionType collectionType);


}
