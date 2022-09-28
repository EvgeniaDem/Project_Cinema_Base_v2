package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.SearchPersonDto;

import java.util.List;

public interface PersonsDtoService {

    List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern);
}
