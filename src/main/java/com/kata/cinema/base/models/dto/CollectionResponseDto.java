package com.kata.cinema.base.models.dto;

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

}
