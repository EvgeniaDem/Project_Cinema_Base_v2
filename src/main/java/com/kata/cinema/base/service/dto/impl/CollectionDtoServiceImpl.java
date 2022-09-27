package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.CollectionDao;
import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.response.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.dto.CollectionDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionDtoServiceImpl extends AbstractServiceImpl<Long, Collection> implements CollectionDtoService {

    private final CollectionDao collectionDao;

    public CollectionDtoServiceImpl(AbstractDao<Long, Collection> abstractDao, CollectionDao collectionDao) {
        super(abstractDao);
        this.collectionDao = collectionDao;
    }

    @Override
    public List<CollectionResponseDto> findCollectionByType(CollectionType collectionType, User user) {
        return collectionDao.findCollectionByType(collectionType, user);
    }

    @Override
    public List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern) {
        return collectionDao.getSearchCollectionWithFilter(filterPattern);
    }
}
