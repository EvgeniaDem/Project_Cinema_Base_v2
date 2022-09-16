package com.kata.cinema.base.dao.dto;

import java.util.List;
import java.util.Map;

public interface PageDtoDao <T>{

    List<T> getItemsDto(Map<String, Object> parameters);
    Long getResultTotal(Map<String, Object> parameters);
}
