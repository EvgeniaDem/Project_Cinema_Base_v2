package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.ReviewMovieResponseDtoDao;
import com.kata.cinema.base.dao.dto.ReviewMovieResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.ReviewMovieResponseDto;
import com.kata.cinema.base.models.dto.response.ReviewResponseDto;
import com.kata.cinema.base.service.dto.ReviewMovieResponseDtoPaginationService;
import com.kata.cinema.base.service.dto.ReviewMovieResponseDtoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReviewMovieResponseDtoServiceImpl implements ReviewMovieResponseDtoService {

    private final ReviewMovieResponseDtoDao reviewMovieResponseDtoDao;
    private final ReviewMovieResponseDtoPaginationService reviewsResponseDtoPaginationService;

    public ReviewMovieResponseDtoServiceImpl(ReviewMovieResponseDtoDao reviewMovieResponseDtoDao, ReviewMovieResponseDtoPaginationService reviewsResponseDtoPaginationService) {
        this.reviewMovieResponseDtoDao = reviewMovieResponseDtoDao;
        this.reviewsResponseDtoPaginationService = reviewsResponseDtoPaginationService;
    }


    @Override
    public ReviewMovieResponseDto getReviewMovieResponseDto(Long id, Integer pageNumber, Integer itemsOnPage, Map<String, Object> parameters) {
        PageDto<ReviewResponseDto> pageDto = reviewsResponseDtoPaginationService.getPageDtoWithParameters(pageNumber,itemsOnPage,parameters);
        ReviewMovieResponseDto reviewMovieResponseDto = reviewMovieResponseDtoDao.getReviewMovieResponseDto(id);
        reviewMovieResponseDto.setPage(pageDto);
        return reviewMovieResponseDto;
    }
}
