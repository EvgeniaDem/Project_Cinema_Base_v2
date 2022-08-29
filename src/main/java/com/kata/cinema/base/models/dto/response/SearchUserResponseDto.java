package com.kata.cinema.base.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchUserResponseDto {

    private Long id;
    private String email;
    private String fullName;
    private String birthday;
    private String avatarUrl;

}
