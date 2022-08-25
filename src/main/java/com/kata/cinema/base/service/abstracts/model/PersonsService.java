package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.Person;

import java.util.List;

public interface PersonsService {

    List<Person> getSearchPersonWithFilter(String filterPattern);
}
