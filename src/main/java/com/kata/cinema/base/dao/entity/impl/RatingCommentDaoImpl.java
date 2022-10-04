package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.RatingCommentDao;
import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.RatingComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingCommentDaoImpl extends AbstractDaoImpl<Long, RatingComment> implements RatingCommentDao {
    @Override
    public List<RatingCommentResponseDto> getRatingByCommentIdAndUserId(Long commentId, Long userId) {
        return entityManager.createQuery(
                        "select new com.kata.cinema.base.models.dto.response.RatingCommentResponseDto(" +
                                " rc.id, rc.rating) from RatingComment rc where rc.comment.id=:commentId and rc.user.id = :userId", RatingCommentResponseDto.class)
                .setParameter("commentId", commentId)
                .setParameter("userId", userId)
                .getResultList();
    }
}
