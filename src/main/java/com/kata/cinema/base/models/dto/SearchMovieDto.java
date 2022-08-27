package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SearchMovieDto {

    private Long id;
    private String name;
    private String originalName;
    private String previewUrl;
    private LocalDate date;
    private Integer avgScore;

    public SearchMovieDto(Long id, String name, String originalName, String previewUrl, LocalDate date) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.previewUrl = previewUrl;
        this.date = date;
    }
}
