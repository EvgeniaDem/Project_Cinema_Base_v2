package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.Person;
import com.kata.cinema.base.service.entity.AbstractService;

import java.util.List;

public interface PersonsService extends AbstractService<Long, Person> {

    List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern);
}
