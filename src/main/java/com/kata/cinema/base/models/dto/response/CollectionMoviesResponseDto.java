package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CollectionMoviesResponseDto {
    Long id;
    String collectionName;
    String description;
    String collectionUrl;
    List<MovieResponseDto> movies;
}
