package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;

import java.util.List;

public interface SearchUserDtoService {

    List<SearchUserResponseDto> findSearchUserByEmail(String email);
}
