package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.ProfessionDao;
import com.kata.cinema.base.models.entitys.Profession;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ProfessionService;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl extends AbstractServiceImpl<Long, Profession> implements ProfessionService {

    private final ProfessionDao professionDao;

    public ProfessionServiceImpl(AbstractDao<Long, Profession> abstractDao, ProfessionDao professionDao) {
        super(abstractDao);
        this.professionDao = professionDao;
    }


    @Override
    public Profession getByName(String name) {
        return professionDao.getByName(name);
    }
}
