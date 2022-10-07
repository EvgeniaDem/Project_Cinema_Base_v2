package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.NewsResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.service.dto.NewsResponseDtoPaginationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("forNewsController")
public class NewsResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<NewsResponseDto> implements NewsResponseDtoPaginationService {

    public NewsResponseDtoPaginationServiceImpl(@Qualifier("newsResponseWithRubric") NewsResponseDtoPaginationDao newsResponseDtoPaginationDao) {
        super(newsResponseDtoPaginationDao);
    }
}
