package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchResponseDto {

    List<SearchMovieDto> movies;
    List<SearchCollectionDto> collections;
    List<SearchPersonDto> persons;

}
