package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;

import java.util.List;

public interface CollectionMoviesResponseDtoDao extends PageDtoDao <CollectionMoviesResponseDto>{

List<Long>collectionMoviesResponseDtoIds(Long id);

}
