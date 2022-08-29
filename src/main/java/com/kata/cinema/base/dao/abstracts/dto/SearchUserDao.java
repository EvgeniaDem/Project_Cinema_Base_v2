package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.models.entitys.User;

import java.util.List;

public interface SearchUserDao extends AbstractDao<Long, User> {


    List<SearchUserResponseDto> findSearchUserByEmail(String email);
}
