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
    private Long id;
    private Integer score;
    private LocalDate date;
    //private Integer time;
    private Long movieId;
    private Long userId;
    //private String name;
    //private String originalName;
    //private LocalDate dateRelease;
    //private Double avgScore;
    //private Long countScore;
}
