package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.UserDao;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//TODO реализовать UserDetailsService отдельным классом
public class UserServiceImpl extends AbstractServiceImpl<Long, User> implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        super(userDao);
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    @Transactional
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.create(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.update(user);
    }
}
