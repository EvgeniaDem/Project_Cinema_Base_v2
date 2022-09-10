package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.cinema.base.models.dto.UserCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentsResponseDto {

    private Long id;

    @NotBlank
    private String message;

    private Long parentId;

    private Integer level;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate date;

    private Integer rating;

    private UserCommentDto user;

}
