package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.entitys.Person;
import com.kata.cinema.base.service.entity.AbstractService;

import java.util.List;

public interface PersonsDtoService extends AbstractService<Long, Person> {

    List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern);
}
