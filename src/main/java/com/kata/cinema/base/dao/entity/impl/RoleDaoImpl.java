package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.RoleDao;
import com.kata.cinema.base.models.entitys.Role;
import com.kata.cinema.base.models.enums.Roles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Long, Role> implements RoleDao {

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findByName(Roles name) {
        return entityManager.createQuery("select r from Role r where r.name=:name", Role.class)
                .setParameter("name", name)
                .getResultList().stream().findAny().orElse(null);
    }

}