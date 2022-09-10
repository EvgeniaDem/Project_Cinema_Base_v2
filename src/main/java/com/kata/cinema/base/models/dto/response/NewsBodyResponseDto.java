package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.cinema.base.models.enums.Rubric;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsBodyResponseDto {

    Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    LocalDate date;

    Integer countComment;

    String title;

    String htmlBody;

    Rubric rubric;

    @NotBlank
    String authorName;

    public NewsBodyResponseDto(Long id, LocalDate date, String title, String htmlBody, Rubric rubric, String authorName) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.htmlBody = htmlBody;
        this.rubric = rubric;
        this.authorName = authorName;
    }

    //test constructor
    public NewsBodyResponseDto(Integer countComment) {
        this.countComment = countComment;
    }
}
