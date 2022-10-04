package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.RatingComment;

import java.util.List;

public interface RatingCommentDao  extends AbstractDao<Long, RatingComment> {
    List<RatingCommentResponseDto> getRatingByCommentIdAndUserId(Long commentId, Long userId);
}
