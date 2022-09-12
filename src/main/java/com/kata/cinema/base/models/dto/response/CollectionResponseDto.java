package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CollectionResponseDto {

    private Long id;
    private String name;
    private String collectionUrl;
    private Integer countMovies;
    private Integer countViewedMovies;

    public CollectionResponseDto(String name, String collectionUrl, Integer countMovies, Integer countViewedMovies) {
        this.name = name;
        this.collectionUrl = collectionUrl;
        this.countMovies = countMovies;
        this.countViewedMovies = countViewedMovies;
    }

}
