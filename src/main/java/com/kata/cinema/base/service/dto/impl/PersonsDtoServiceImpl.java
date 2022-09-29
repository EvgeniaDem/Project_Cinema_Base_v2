package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.PersonsDao;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.entitys.Person;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.dto.PersonsDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsDtoServiceImpl extends AbstractServiceImpl<Long, Person> implements PersonsDtoService {

    private final PersonsDao personsDao;

    public PersonsDtoServiceImpl(AbstractDao<Long, Person> abstractDao, PersonsDao personsDao) {
        super(abstractDao);
        this.personsDao = personsDao;
    }

    @Override
    public List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern) {
        return personsDao.getSearchPersonWithFilter(filterPattern);
    }
}
