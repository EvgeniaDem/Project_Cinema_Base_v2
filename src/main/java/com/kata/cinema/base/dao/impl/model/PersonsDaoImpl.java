package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.PersonsDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.entitys.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonsDaoImpl extends AbstractDaoImpl<Person, Long> implements PersonsDao {

    @Override
    public List<Person> getSearchPersonWithFilter(String filterPattern) {
        return null;
    }
}
