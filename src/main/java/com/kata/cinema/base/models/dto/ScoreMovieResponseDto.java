package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
//@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class ScoreMovieResponseDto {
    Long id;
    Integer score;
    LocalDate date;
    //Integer time;
    Long movieId;
    Long userId;
    //String name;
    //String originalName;
    //LocalDate dateRelease;
    //Double avgScore;
    //Long countScore;

/*    public ScoreMovieResponseDto(Long id, Integer score, Long movieId, Long userId) {
        this.id = id;
        this.score = score;
        this.movieId = movieId;
        this.userId = userId;
    }*/
}
