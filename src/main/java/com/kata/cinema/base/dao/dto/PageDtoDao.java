package com.kata.cinema.base.dao.dto;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PageDtoDao<T> {

    List<T> getItemsDto(Long id, Map<String, Object> parameters);

    Long getResultTotal(Long id, Map<String, Object> parameters);
}
