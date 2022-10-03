package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.dao.entity.ReviewDao;
import com.kata.cinema.base.models.entitys.Review;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends AbstractServiceImpl<Long, Review> implements ReviewService {

    public ReviewServiceImpl(ReviewDao reviewDao) {
        super(reviewDao);
    }
}
