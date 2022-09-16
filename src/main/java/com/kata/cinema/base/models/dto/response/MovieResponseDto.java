package com.kata.cinema.base.models.dto.response;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponseDto {
    Long id;
    String name;
    String originalName;
    Integer time;
    LocalDate dateRelease;
    String countries;
    String genres;
    String director;
    String roles;
    Double avgScore;
}
