package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.ProfessionDao;
import com.kata.cinema.base.models.entitys.Profession;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class ProfessionDaoImpl extends AbstractDaoImpl<Long, Profession> implements ProfessionDao {

    @Override
    public Profession getByName(String name) {
        return entityManager.createQuery("select p from Profession p where p.name = (:name)", Profession.class)
                .setParameter("name",name).getSingleResult();
    }
}
