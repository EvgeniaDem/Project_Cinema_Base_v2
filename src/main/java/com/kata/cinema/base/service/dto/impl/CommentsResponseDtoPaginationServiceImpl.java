package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.service.dto.CommentsResponseDtoPaginationService;
import org.springframework.stereotype.Service;

@Service
public class CommentsResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<CommentsResponseDto> implements CommentsResponseDtoPaginationService {

    public CommentsResponseDtoPaginationServiceImpl(PaginationDtoDao<CommentsResponseDto> paginationDtoDao) {
        super(paginationDtoDao);
    }

    @Override
    public PageDto<CommentsResponseDto> getPageDto(Integer currentPage, Integer itemsOnPage) {
        return super.getPageDto(currentPage, itemsOnPage);
    }
}
