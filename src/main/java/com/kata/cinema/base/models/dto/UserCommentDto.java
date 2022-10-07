package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommentDto {

    private Long id;
    private String login;
    private String avatarUrl;
}
