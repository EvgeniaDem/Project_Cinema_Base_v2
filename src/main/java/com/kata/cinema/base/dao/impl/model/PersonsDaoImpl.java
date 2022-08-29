package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.PersonsDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.entitys.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonsDaoImpl extends AbstractDaoImpl<Person, Long> implements PersonsDao {

    @Override
    public List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.SearchPersonDto(p.id,concat(p.firstName, ' ', p.lastName) as fullName, concat(p.originalName, ' ',  p.originalLastName) as originalFullName, p.photoUrl, p.birthday) from Person p where lower(p.firstName) like lower(:filter)", SearchPersonDto.class)
                .setParameter("filter", filterPattern + "%")
                .setMaxResults(3)
                .getResultList();
    }
}
