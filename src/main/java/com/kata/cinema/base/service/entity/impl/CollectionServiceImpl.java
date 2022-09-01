package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.CollectionDao;
import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.CollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl extends AbstractServiceImpl<Long, Collections> implements CollectionService {

    private final CollectionDao collectionDao;

    public CollectionServiceImpl(AbstractDao<Long, Collections> abstractDao, CollectionDao collectionDao) {
        super(abstractDao);
        this.collectionDao = collectionDao;
    }

    @Override
    public List<Collections> findCollectionByType(CollectionType collectionType) {
        return collectionDao.findCollectionByType(collectionType);
    }
}
