package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.entitys.Genres;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class SearchMovieResponseDto {
    private Long id;
    private String name;
    private LocalDate dateRelease;
    private String contentUrl;
    private List<String> genres;

    public SearchMovieResponseDto(Long id, String name, LocalDate dateRelease, String contentUrl) {
        this.id = id;
        this.name = name;
        this.dateRelease = dateRelease;
        this.contentUrl = contentUrl;
    }

}
