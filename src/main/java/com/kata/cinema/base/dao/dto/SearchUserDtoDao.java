package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.models.entitys.User;

import java.util.List;

public interface SearchUserDtoDao {

    List<SearchUserResponseDto> findSearchUserByEmail(String email);
}
