package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SearchPersonDto {

    private Long id;
    private String photoUrl;
    private String fullName;
    private String originalFullName;
    private LocalDate birthday;

}
