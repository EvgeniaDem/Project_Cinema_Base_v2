package com.kata.cinema.base.models.dto.response;

import java.util.List;

public class CollectionMoviesResponseDto {
    Long id;
    String collectionName;
    String description;
    String collectionUrl;
    List<MovieResponseDto> movies;

    public CollectionMoviesResponseDto(Long id, String collectionName, String description, String collectionUrl) {
        this.id = id;
        this.collectionName = collectionName;
        this.description = description;
        this.collectionUrl = collectionUrl;
    }
}
