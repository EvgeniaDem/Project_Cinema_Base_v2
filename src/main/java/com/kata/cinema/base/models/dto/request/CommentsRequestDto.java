package com.kata.cinema.base.models.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CommentsRequestDto {
    @NotBlank
    private String message;

    private Long parentId;

    private Integer level;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime localDateTime;

    public CommentsRequestDto(String message, Long parentId, Integer level) {
        this.message = message;
        this.parentId = parentId;
        this.level = level;
    }
}
