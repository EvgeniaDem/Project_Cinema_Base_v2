package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.SearchUserDtoDao;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.service.dto.SearchUserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserDtoServiceImpl implements SearchUserDtoService {

    private final SearchUserDtoDao searchUserDao;

    @Autowired
    public SearchUserDtoServiceImpl(SearchUserDtoDao searchUserDao) {
        this.searchUserDao = searchUserDao;
    }

    @Override
    public List<SearchUserResponseDto> findSearchUserByEmail(String email) {
        return searchUserDao.findSearchUserByEmail(email);
    }
}
