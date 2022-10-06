package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.ReactionReviewDao;
import com.kata.cinema.base.models.entitys.ReactionReview;
import com.kata.cinema.base.models.entitys.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReactionReviewDaoImpl extends AbstractDaoImpl<Long, Review> implements ReactionReviewDao {
    @Override
    public List<ReactionReview> getReactionReview(Long id) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.entitys.ReactionReview(rr.id, rr.rating) " +
                        "from ReactionReview rr where rr.review.id = :id", ReactionReview.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public Long getUserId(Long id) {
        return (Long) entityManager.createQuery("select rr.user.id from ReactionReview rr where rr.review.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

}
