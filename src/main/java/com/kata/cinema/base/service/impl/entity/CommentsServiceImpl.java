package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.CommentsDao;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comments;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.CommentsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CommentsServiceImpl extends AbstractServiceImpl<Long, Comments> implements CommentsService {

    private final CommentsDao commentsDao;

    public CommentsServiceImpl(CommentsDao commentsDao) {
        super(commentsDao);
        this.commentsDao = commentsDao;
    }

    @Override
    public List<CommentsResponseDto> getComments(Long id) {
        return commentsDao.getListOfComments(id);
    }
}

