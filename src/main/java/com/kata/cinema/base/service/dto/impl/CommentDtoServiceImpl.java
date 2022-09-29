package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.entity.CommentDao;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.dto.CommentDtoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDtoServiceImpl extends AbstractServiceImpl<Long, Comment> implements CommentDtoService {

    private final CommentDao commentDao;

    public CommentDtoServiceImpl(CommentDao commentDao) {
        super(commentDao);
        this.commentDao = commentDao;
    }

    @Override
    public List<CommentsResponseDto> getComments(Long id) {
        return commentDao.getListOfComments(id);
    }
}

