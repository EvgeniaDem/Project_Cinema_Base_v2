package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.PageDto;

import java.util.Map;

public interface PageDtoServise<T> {
    PageDto<T> getPageDtoWithParameters(Long id, Map<String, Object> parameters);
}
