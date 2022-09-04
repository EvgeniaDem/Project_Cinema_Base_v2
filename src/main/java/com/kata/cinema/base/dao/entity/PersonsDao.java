package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.entitys.Person;

import java.util.List;

public interface PersonsDao extends AbstractDao<Person, Long> {

    List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern);
}
