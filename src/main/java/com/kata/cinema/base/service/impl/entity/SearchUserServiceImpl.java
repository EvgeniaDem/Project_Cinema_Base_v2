package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.dto.SearchUserDao;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.service.abstracts.model.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserServiceImpl implements SearchUserService {

    private final SearchUserDao searchUserDao;

    @Autowired
    public SearchUserServiceImpl(SearchUserDao searchUserDao) {
        this.searchUserDao = searchUserDao;
    }

    @Override
    public List<SearchUserResponseDto> findSearchUserByEmail(String email) {
        return searchUserDao.findSearchUserByEmail(email);
    }
}
