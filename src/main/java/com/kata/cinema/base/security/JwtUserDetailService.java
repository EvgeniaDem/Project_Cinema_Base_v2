package com.kata.cinema.base.security;

import com.kata.cinema.base.dao.abstracts.dto.UserDao;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.entity.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailService implements UserDetailsService {
    private final UserDao userDao;

    @Autowired
    public JwtUserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + username + "not found");
        }
        log.info("IN loadUserByUsername - user with email: {} successfully loaded", username);
        return user;
    }
}
