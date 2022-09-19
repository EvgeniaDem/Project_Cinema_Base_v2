package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String originalName;

    @NotBlank
    private Integer time;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateRelease;

    @NotBlank
    private String countries;

    @NotBlank
    private String genres;

    @NotBlank
    private String director;

    @NotBlank
    private String roles;

    public MovieResponseDto(Long id, String name, String originalName, Integer time, LocalDate dateRelease, String countries) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.time = time;
        this.dateRelease = dateRelease;
        this.countries = countries;
    }
}
