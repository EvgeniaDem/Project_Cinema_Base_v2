package com.kata.cinema.base.models;

import lombok.Data;

@Data
public class MovieScoreRequest {
    private Integer score;
    private Long movieId;
}
