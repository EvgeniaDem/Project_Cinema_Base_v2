package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.RoleDao;
import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.models.enums.Roles;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Long, Role> implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }

    @Override
    public Role getByName(Roles name) {
        return roleDao.findByName(name);
    }
}
