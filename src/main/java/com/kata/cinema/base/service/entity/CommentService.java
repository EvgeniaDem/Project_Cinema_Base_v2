package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.entitys.Comment;

public interface CommentService extends AbstractService<Long, Comment> {
    void updateIsModerateToTrueById(Long id);

    void deleteCommentById(Long id);
}
