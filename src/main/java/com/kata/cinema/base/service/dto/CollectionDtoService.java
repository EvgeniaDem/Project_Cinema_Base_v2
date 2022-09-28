package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.response.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.entity.AbstractService;

import java.util.List;


public interface CollectionDtoService extends AbstractService<Long, Collection> {

    List<CollectionResponseDto> findCollectionByType(CollectionType collectionType, User user);

    List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern);
}
