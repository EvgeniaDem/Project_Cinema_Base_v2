package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.User;
import liquibase.changelog.AbstractChangeLogHistoryService;

import java.util.List;

public interface UserService extends AbstractService<Long, User> {

    User findByEmail(String email);


}
