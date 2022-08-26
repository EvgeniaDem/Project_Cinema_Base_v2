package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.PersonsDao;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.service.abstracts.model.PersonsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {

    private PersonsDao personsDao;

    public PersonsServiceImpl(PersonsDao personsDao) {
        this.personsDao = personsDao;
    }

    @Override
    public List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern) {
        return personsDao.getSearchPersonWithFilter(filterPattern);
    }
}
