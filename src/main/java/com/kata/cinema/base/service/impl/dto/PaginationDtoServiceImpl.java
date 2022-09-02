package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.service.abstracts.dto.PaginationDtoService;

import java.util.HashMap;
import java.util.Map;

public class PaginationDtoServiceImpl<T> implements PaginationDtoService<T> {

    private final PaginationDtoDao<T> paginationDtoDao;


    public PaginationDtoServiceImpl(PaginationDtoDao<T> paginationDtoDao) {
        this.paginationDtoDao = paginationDtoDao;
    }


    @Override
    public PageDto<T> getPageDto(Integer currentPage, Integer itemsOnPage) {
        PageDto<T> pageDto = new PageDto<>();
        Map<String, Object> parameters = new HashMap<>();
        pageDto.setCount(paginationDtoDao.getResultTotal(parameters));
        pageDto.setEntities(paginationDtoDao.getItemsDto(currentPage, itemsOnPage, parameters));

        return pageDto;
    }

    @Override
    public PageDto<T> getPageDtoWithParameters(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setCount(paginationDtoDao.getResultTotal(parameters));
        pageDto.setEntities(paginationDtoDao.getItemsDto(currentPage, itemsOnPage, parameters));

        return pageDto;
    }
}
