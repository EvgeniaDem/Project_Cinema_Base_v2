package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.entitys.Collections;

import java.util.List;

public interface CollectionsDao extends AbstractDao<Collections, Long> {

    List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern);
}
