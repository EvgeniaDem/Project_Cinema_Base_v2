package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.Review;
import com.kata.cinema.base.models.enums.TypeRating;

public interface ReactionReviewService extends AbstractService<Long, Review> {

    void getRatingForReview(Long id, TypeRating typeRating);
}
