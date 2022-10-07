package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.NewsResponseDtoPaginationDao;
import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.service.dto.NewsResponseDtoPaginationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("forMovieController")
public class NewsResponseDtoPaginationServiceImplForMovie extends PaginationDtoServiceImpl<NewsResponseDto> implements NewsResponseDtoPaginationService {

    public NewsResponseDtoPaginationServiceImplForMovie(@Qualifier("newsResponseForMovie") NewsResponseDtoPaginationDao newsResponseDtoPaginationDao) {
        super(newsResponseDtoPaginationDao);
    }
}
