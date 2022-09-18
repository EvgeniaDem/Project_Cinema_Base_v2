package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public CollectionMoviesResponseDto() {

    }

    public CollectionMoviesResponseDto(Long id, String collectionName, String description, String collectionUrl) {
        this.id = id;
        this.collectionName = collectionName;
        this.description = description;
        this.collectionUrl = collectionUrl;
    }
}
