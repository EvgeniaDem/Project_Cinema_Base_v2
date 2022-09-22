package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.enums.TypeReview;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewResponseDto {

    private Long id;
    private TypeReview typeReview;
    private String title;
    private String description;
    private String fullName;
    private LocalDate date;

    public ReviewResponseDto(Long id, TypeReview typeReview, String title, String description, String fullName, LocalDate date) {
        this.id = id;
        this.typeReview = typeReview;
        this.title = title;
        this.description = description;
        this.fullName = fullName;
        this.date = date;
    }

}
