package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.RatingCommentDao;
import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.RatingComment;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.RatingCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingCommentServiceImpl extends AbstractServiceImpl<Long, RatingComment> implements RatingCommentService {

    private RatingCommentDao ratingCommentDao;

    public RatingCommentServiceImpl(RatingCommentDao ratingCommentDao) {
        super(ratingCommentDao);
        this.ratingCommentDao = ratingCommentDao;
    }

    @Override
    public List<RatingCommentResponseDto> getRatingByCommentIdAndUserId(Long commentId, Long userId) {
        return ratingCommentDao.getRatingByCommentIdAndUserId(commentId, userId);
    }
}
