package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.entitys.ReactionReview;
import com.kata.cinema.base.models.entitys.Review;

import java.util.List;

public interface ReactionReviewDao extends AbstractDao<Long, Review> {
    List<ReactionReview> getReactionReview(Long id);

    Long getUserId(Long id);
}
