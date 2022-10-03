package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.entitys.ProductionStudio;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ProductionStudioService;
import org.springframework.stereotype.Service;

@Service
public class ProductionStudioServiceImpl extends AbstractServiceImpl<Long, ProductionStudio> implements ProductionStudioService {

    public ProductionStudioServiceImpl(AbstractDao<Long, ProductionStudio> abstractDao) {
        super(abstractDao);
    }
}
