package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.PersonsDao;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.service.abstracts.model.PersonsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    private final PersonsDao personsDao;

    public PersonsServiceImpl(PersonsDao personsDao) {
        this.personsDao = personsDao;
    }

    @Override
    public List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern) {
        return personsDao.getSearchPersonWithFilter(filterPattern);
    }
}
