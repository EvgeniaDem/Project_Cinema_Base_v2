package com.kata.cinema.base.models.dto.response;

import java.util.List;

public class CollectionMoviesResponseDto {
    Long id;
    String collectionName;
    String description;
    String collectionUrl;
    List<MovieResponseDto> movies;

}
