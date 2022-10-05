package com.kata.cinema.base.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.cinema.base.models.entitys.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieTicketDto {
    private Movie movie;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate endShowDate;
}
