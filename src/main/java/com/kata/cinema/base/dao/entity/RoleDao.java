package com.kata.cinema.base.dao.entity;


import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.entitys.Role;

public interface RoleDao extends AbstractDao<Long, Role> {

    Role findByName(Roles name);

}
