package com.kata.cinema.base.dao.entity;


import com.kata.cinema.base.models.entitys.User;

public interface UserDao extends AbstractDao<Long, User> {

    User findUserByEmail(String email);
}
