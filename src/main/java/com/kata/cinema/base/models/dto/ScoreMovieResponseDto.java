package com.kata.cinema.base.models.dto;

import lombok.*;

import java.time.LocalDate;

@Data
//@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class ScoreMovieResponseDto {
    Long id;
    Integer score;
    //LocalDate date;
    //Integer time;
    Long movieId;
    Long userId;
    //String name;
    //String originalName;
    //LocalDate dateRelease;
    //Double avgScore;
    //Long countScore;

    public ScoreMovieResponseDto(Long movieId, Long userId) {
        this.movieId = movieId;
        this.userId = userId;
    }
}
