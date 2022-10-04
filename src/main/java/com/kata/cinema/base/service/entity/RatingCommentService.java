package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.RatingComment;

import java.util.List;

public interface RatingCommentService extends AbstractService <Long, RatingComment> {
    List<RatingCommentResponseDto> getRatingByCommentIdAndUserId(Long commentId, Long userId);
}
