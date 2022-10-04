package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.Profession;

public interface ProfessionDao extends AbstractDao<Long, Profession> {
    Profession getByName(String name);
}
