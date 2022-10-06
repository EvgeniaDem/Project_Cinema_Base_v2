package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.enums.TypeRating;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RatingCommentResponseDto {

    private Long id;

    private TypeRating rating;
}
