package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.response.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.CollectionType;

import java.util.List;


public interface CollectionDao extends AbstractDao<Long, Collection> {

    List<CollectionResponseDto> findCollectionByType(CollectionType collectionType, User user);

    List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern);

}
