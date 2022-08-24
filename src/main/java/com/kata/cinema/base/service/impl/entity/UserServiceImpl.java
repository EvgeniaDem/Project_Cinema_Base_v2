package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.dao.abstracts.dto.UserDao;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//TODO реализовать UserDetailsService отдельным классом
public class UserServiceImpl extends AbstractServiceImpl<Long, User> implements UserService, UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public User findByEmail(String email) {
        return (User) userDao.findUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User) userDao.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User: " + email + " not found");
        }

        //TODO а почему нельзя сразу возврощать user??
        return new User(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getBirthday(), user.getAvatarUrl());
    }
}
