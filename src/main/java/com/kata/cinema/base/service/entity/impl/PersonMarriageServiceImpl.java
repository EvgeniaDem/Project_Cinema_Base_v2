package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.entitys.PersonMarriage;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.PersonMarriageService;
import org.springframework.stereotype.Service;

@Service
public class PersonMarriageServiceImpl extends AbstractServiceImpl<Long, PersonMarriage> implements PersonMarriageService {

    public PersonMarriageServiceImpl(AbstractDao<Long, PersonMarriage> abstractDao) {
        super(abstractDao);
    }
}
