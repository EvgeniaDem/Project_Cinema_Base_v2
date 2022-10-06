package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.ReactionReviewDao;
import com.kata.cinema.base.models.entitys.ReactionReview;
import com.kata.cinema.base.models.entitys.Review;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.TypeRating;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ReactionReviewService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionReviewServiceImpl extends AbstractServiceImpl<Long, Review> implements ReactionReviewService {
    private final ReactionReviewDao reactionReviewDao;

    public ReactionReviewServiceImpl(ReactionReviewDao reactionReviewDao) {
        super(reactionReviewDao);
        this.reactionReviewDao = reactionReviewDao;
    }

    @Override
    public void getRatingForReview(Long id, TypeRating typeRating) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ReactionReview> reactionReviewList = reactionReviewDao.getReactionReview(id);
        for (int i = 1; i < reactionReviewList.size(); i++) {
            ReactionReview reactionReview = reactionReviewList.get(i);
            if (reactionReviewList.get(i).getId() != user.getId()) {
                reactionReview.setRating(typeRating);
            }
        }
    }
}

