package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCollectionDto {

    private String name;
    private String url;
    private Integer countMovies;

}
