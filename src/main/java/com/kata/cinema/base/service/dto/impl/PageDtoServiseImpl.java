package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PageDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.service.dto.PageDtoServise;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class PageDtoServiseImpl<T> implements PageDtoServise<T> {

    private final PageDtoDao<T> pageDtoDao;

    public PageDtoServiseImpl(PageDtoDao<T> pageDtoDao) {
        this.pageDtoDao = pageDtoDao;
    }


    @Override
    public PageDto<T> getPageDtoWithParameters(Long id, Map<String, Object> parameters, LocalDate date) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setCount(pageDtoDao.getResultTotal(id,parameters));
        pageDto.setEntities(pageDtoDao.getItemsDto(id,parameters));
        return pageDto;
    }
}
