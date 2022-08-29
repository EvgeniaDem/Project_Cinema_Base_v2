package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.Role;

public interface RoleService extends AbstractService<Long, Role> {

    Role findByName(String name);
}
