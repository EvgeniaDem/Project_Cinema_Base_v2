package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.UserDao;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<Long, User> implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
