package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.enums.TypeReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {

    private Long id;
    private TypeReview typeReview;
    private String title;
    private String description;
    private String fullName;
    private LocalDate date;
    private Integer countRatingLike;
    private Integer countRatingDislike;

}
