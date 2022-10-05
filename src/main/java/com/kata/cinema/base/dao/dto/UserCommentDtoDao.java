package com.kata.cinema.base.dao.dto;

import com.kata.cinema.base.models.dto.UserCommentDto;

import java.util.Map;

public interface UserCommentDtoDao {
    Map<Long, UserCommentDto> getMapForCommentsResponseDto();
}
