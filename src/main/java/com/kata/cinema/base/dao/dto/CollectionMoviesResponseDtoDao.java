package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;

import java.util.List;
import java.util.Map;

public interface CollectionMoviesResponseDtoDao extends PageDtoDao <CollectionMoviesResponseDto>{

//    Map<Long, List<MovieResponseDto>> getAllCollections();
List<Long>collectionMoviesResponseDtoIds(Long id);

}
