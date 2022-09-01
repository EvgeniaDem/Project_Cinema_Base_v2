package com.kata.cinema.base.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SearchPersonDto {

    private Long id;
    private String fullName;
    private String originalFullName;
    private String photoUrl;
    private Date birthday;

}
