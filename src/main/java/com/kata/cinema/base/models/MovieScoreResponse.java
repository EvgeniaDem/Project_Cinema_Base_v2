package com.kata.cinema.base.models;

import lombok.Data;

@Data
public class MovieScoreResponse {
    private Long userId;
    private Long movieId;
    private boolean isCreated;
    private String message;
}
