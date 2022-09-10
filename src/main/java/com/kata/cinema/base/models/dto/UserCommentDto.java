package com.kata.cinema.base.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCommentDto {

    private Long id;
    private String login;
    private String avatarUrl;
}
