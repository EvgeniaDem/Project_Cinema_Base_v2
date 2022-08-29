package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.dao.abstracts.dto.RoleDao;
import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Long, Role> implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(AbstractDao<Long, Role> abstractDao, RoleDao roleDao) {
        super(abstractDao);
        this.roleDao = roleDao;
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
