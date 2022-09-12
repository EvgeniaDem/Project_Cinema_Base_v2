package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.ReviewMovieResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.response.ReviewResponseDto;
import com.kata.cinema.base.service.dto.ReviewMovieResponseDtoPaginationService;
import org.springframework.stereotype.Service;

@Service
public class ReviewMovieResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<ReviewResponseDto> implements ReviewMovieResponseDtoPaginationService {
    public ReviewMovieResponseDtoPaginationServiceImpl(ReviewMovieResponseDtoPaginationDao paginationDtoDao) {
        super(paginationDtoDao);
    }
}
