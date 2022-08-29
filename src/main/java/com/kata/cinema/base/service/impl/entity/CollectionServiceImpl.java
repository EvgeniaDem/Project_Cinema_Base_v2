package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.dao.abstracts.dto.CollectionDao;
import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.CollectionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionServiceImpl extends AbstractServiceImpl<Long, Collections> implements CollectionService {

    private CollectionDao collectionDao;

    public CollectionServiceImpl(AbstractDao<Long, Collections> abstractDao, CollectionDao collectionDao) {
        super(abstractDao);
        this.collectionDao = collectionDao;
    }

    @Override
    public Collections findCollectionByType(CollectionType collectionType) {
        return collectionDao.findCollectionByType(collectionType);
    }


    @Override
    public List<Collections> getAll() {
        return collectionDao.getAll();
    }

    @Override
    @Transactional
    public void create(Collections entity) {
        collectionDao.create(entity);
    }

    @Override
    @Transactional
    public void update(Collections entity) {
        collectionDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Collections entity) {
        collectionDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        collectionDao.deleteById(id);
    }

    @Override
    public Optional<Collections> getById(Long id) {
        return collectionDao.getById(id);
    }

    @Override
    public boolean isExistById(Long id) {
        return collectionDao.isExistById(id);
    }
}
