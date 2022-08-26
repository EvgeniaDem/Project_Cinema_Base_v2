package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.dto.SearchPersonDto;

import java.util.List;

public interface PersonsService {

    List<SearchPersonDto> getSearchPersonWithFilter(String filterPattern);
}
