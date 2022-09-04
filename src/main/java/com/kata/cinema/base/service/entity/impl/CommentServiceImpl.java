package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.CommentDao;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Long, Comment> implements CommentService {

    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        super(commentDao);
        this.commentDao = commentDao;
    }

    @Override
    public List<CommentsResponseDto> getComments(Long id) {
        return commentDao.getListOfComments(id);
    }
}

