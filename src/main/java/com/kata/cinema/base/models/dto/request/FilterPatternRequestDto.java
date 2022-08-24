package com.kata.cinema.base.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterPatternRequestDto {

    private String movieName;
    private String personName;
    private String collectionName;
}
