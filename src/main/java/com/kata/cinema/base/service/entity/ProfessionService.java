package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.Profession;

public interface ProfessionService extends AbstractService<Long, Profession> {

    Profession getByName(String name);
}
