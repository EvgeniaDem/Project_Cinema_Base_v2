package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.CollectionMoviesResponseDtoDao;
import com.kata.cinema.base.dao.dto.MovieResponseDtoDao;
import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.TopMoviesResponseDto;
import com.kata.cinema.base.service.dto.MovieResponseDtoService;
import liquibase.pro.packaged.T;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MovieResponseDtoServiceImpl implements MovieResponseDtoService {

    @Autowired
    MovieResponseDtoDao movieResponseDtoDao;
    private final PaginationDtoDao<T> paginationDtoDao;
    CollectionMoviesResponseDtoDao collectionMoviesResponseDtoDao;

    public MovieResponseDtoServiceImpl(PaginationDtoDao<T> paginationDtoDao) {
        this.paginationDtoDao = paginationDtoDao;
    }


    @Override
    public PageDto<CollectionMoviesResponseDto> getPageDto(Map<String, Object> parameters) {
        PageDto<CollectionMoviesResponseDto> pageDto = new PageDto<>();
        pageDto.setCount(paginationDtoDao.getResultTotal(parameters));
//        pageDto.setEntities(collectionMoviesResponseDtoDao.getAllCollections());
//        Map<Long, List<String>> movieResponseDtoMap = collectionMoviesResponseDtoDao.getAllCollections();

        return null;
    }
}
