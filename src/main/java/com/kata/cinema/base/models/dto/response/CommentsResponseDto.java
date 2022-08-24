package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentsResponseDto {
    Long id;
    @NotBlank
    String text;
    LocalDateTime localDateTime;
}
