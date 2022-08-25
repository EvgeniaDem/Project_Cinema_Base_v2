package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.SearchCollectionDto;

import java.util.List;

public interface CollectionsService {

    List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern);
}
