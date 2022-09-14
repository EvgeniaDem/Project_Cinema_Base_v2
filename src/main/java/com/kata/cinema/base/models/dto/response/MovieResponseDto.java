package com.kata.cinema.base.models.dto.response;

import java.time.LocalDate;

public class MovieResponseDto {
    Long id;
    String name;
    String originalName;
 //  String name;
    Integer time;
    LocalDate dateRelease;
    String countries;
    String genres;
    String director; //- режиссер
    String roles;
    Double avgScore;

    public MovieResponseDto(Long id, String name, String originalName, Integer time, LocalDate dateRelease, String countries, String genres, String director, String roles, Double avgScore) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.time = time;
        this.dateRelease = dateRelease;
        this.countries = countries;
        this.genres = genres;
        this.director = director;
        this.roles = roles;
        this.avgScore = avgScore;
    }
}
