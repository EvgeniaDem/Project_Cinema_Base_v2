package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kata.cinema.base.models.dto.UserCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentsResponseDto {

    private Long id;

    private String message;

    private Long parentId;

    private Integer level;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate date;

    private Integer rating;

    private UserCommentDto user;

    public CommentsResponseDto(Long id, String message, Long parentId, Integer level, LocalDate date, Integer rating,
                               Long idUser, String login, String avatarUrl) {
        this.id = id;
        this.message = message;
        this.parentId = parentId;
        this.level = level;
        this.date = date;
        this.rating = rating;
        this.user = new UserCommentDto(idUser, login, avatarUrl);
    }
}
