package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.models.enums.Roles;

public interface RoleService extends AbstractService<Long, Role> {
    Role getByName(Roles name);
}
