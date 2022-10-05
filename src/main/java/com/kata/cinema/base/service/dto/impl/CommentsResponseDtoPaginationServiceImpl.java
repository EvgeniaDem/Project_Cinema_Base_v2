package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.dto.UserCommentDtoDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.UserCommentDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.service.dto.CommentsResponseDtoPaginationService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentsResponseDtoPaginationServiceImpl extends PaginationDtoServiceImpl<CommentsResponseDto> implements CommentsResponseDtoPaginationService {

    private final UserCommentDtoDao userCommentDtoDao;

    public CommentsResponseDtoPaginationServiceImpl(PaginationDtoDao<CommentsResponseDto> paginationDtoDao,
                                                    UserCommentDtoDao userCommentDtoDao) {
        super(paginationDtoDao);
        this.userCommentDtoDao = userCommentDtoDao;
    }

    @Override
    public PageDto<CommentsResponseDto> getPageDto(Integer currentPage, Integer itemsOnPage) {
        PageDto<CommentsResponseDto> pageDto = super.getPageDto(currentPage, itemsOnPage);
        Map<Long, UserCommentDto> dtoMap = userCommentDtoDao.getMapForCommentsResponseDto();
        for (CommentsResponseDto dto: pageDto.getEntities()) {
            dto.setUser(dtoMap.get(dto.getUser().getId()));
        }
        return pageDto;
    }
}
