package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class TopMoviesResponseDto {
    private Long id;
    private String name;
    private String originalName;
    private String countries;
    private List<String> genres;
    private List<String> actorsName;
    private Integer time;
    private String contentUrl;
    private Integer countScore;
    private Double avgScore;

    public TopMoviesResponseDto(Long id, String name, String originalName, String countries, Integer time, String contentUrl, Integer countScore, Double avgScore) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.countries = countries;
        this.time = time;
        this.contentUrl = contentUrl;
        this.countScore = countScore;
        this.avgScore = avgScore;
        this.genres = new ArrayList<>();
        this.actorsName = new ArrayList<>();
    }
}
