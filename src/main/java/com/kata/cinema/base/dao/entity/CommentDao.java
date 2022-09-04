package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends AbstractDao<Long, Comment> {
    List<CommentsResponseDto> getListOfComments(Long id);
}
