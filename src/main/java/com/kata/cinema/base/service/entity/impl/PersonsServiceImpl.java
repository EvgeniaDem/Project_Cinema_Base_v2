package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.PersonsDao;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.entitys.Person;
import com.kata.cinema.base.service.abstracts.model.PersonsService;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl extends AbstractServiceImpl<Long, Person> implements PersonsService {

    private final PersonsDao personsDao;

    public PersonsServiceImpl(AbstractDao<Long, Person> abstractDao, PersonsDao personsDao) {
        super(abstractDao);
        this.personsDao = personsDao;
    }

    @Override
    public List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern) {
        return personsDao.getSearchPersonWithFilter(filterPattern);
    }
}
