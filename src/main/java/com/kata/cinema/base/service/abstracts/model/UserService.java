package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.User;


public interface UserService extends AbstractService<Long, User> {

    User findByEmail(String email);


}
