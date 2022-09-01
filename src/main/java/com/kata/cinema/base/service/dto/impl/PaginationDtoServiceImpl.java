package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.service.dto.PaginationDtoService;

import java.util.HashMap;
import java.util.Map;

public class PaginationDtoServiceImpl<T> implements PaginationDtoService<T> {

    private final PaginationDtoDao<T> paginationDtoDao;


    public PaginationDtoServiceImpl(PaginationDtoDao<T> paginationDtoDao) {
        this.paginationDtoDao = paginationDtoDao;
    }


    @Override
    public PageDto<T> getPageDto(Integer currentPage, Integer itemsOnPage) {
        return getPageDtoWithParameters(currentPage, itemsOnPage, new HashMap<>());
    }

    @Override
    public PageDto<T> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setCount(paginationDtoDao.getResultTotal(parameters));
        pageDto.setEntities(paginationDtoDao.getItemsDto(currentPage, itemsOnPage, parameters));
        return pageDto;
    }
}
