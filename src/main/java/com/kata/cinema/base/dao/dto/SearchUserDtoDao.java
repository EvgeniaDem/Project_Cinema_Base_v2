package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;

import java.util.List;

public interface SearchUserDtoDao {

    List<SearchUserResponseDto> findSearchUserByEmail(String email);
}
