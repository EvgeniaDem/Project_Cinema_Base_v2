package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.CollectionsDao;
import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.service.abstracts.model.CollectionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionsServiceImpl implements CollectionsService {

    private CollectionsDao collectionsDao;

    public CollectionsServiceImpl(CollectionsDao collectionsDao) {
        this.collectionsDao = collectionsDao;
    }

    @Override
    public List<SearchCollectionDto> getSearchCollectionWithFilter(String filterPattern) {
        return collectionsDao.getSearchCollectionWithFilter(filterPattern);
    }
}
