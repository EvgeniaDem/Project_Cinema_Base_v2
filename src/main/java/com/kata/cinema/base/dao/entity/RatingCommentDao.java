package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.RatingComment;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.TypeRating;

import java.util.List;

public interface RatingCommentDao  extends AbstractDao<Long, RatingComment> {
    List<RatingCommentResponseDto> getRatingByCommentIdAndUserId(Long commentId, Long userId);

    void patchComment(Long idComment, User user, TypeRating typeRating);
}
