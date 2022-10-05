package com.kata.cinema.base.service.entity.impl;

import com.kata.cinema.base.dao.entity.AbstractDao;
import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.entity.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Long, Comment> implements CommentService {

    public CommentServiceImpl(@Qualifier("commentDaoImpl") AbstractDao<Long, Comment> abstractDao) {
        super(abstractDao);
    }

    @Override
    @Transactional
    public void updateIsModerateToTrueById(Long id) {
        Optional<Comment> optionalComment = getById(id);
        if (optionalComment.isEmpty()) {
            throw new NotFoundByIdException("There is no comment with ID: " + id + ", try again.");
        }
        Comment comment = optionalComment.get();
        comment.setIsModerate(true);
        update(comment);
    }

    @Override
    @Transactional
    public void deleteCommentById(Long id) {
        if (!isExistById(id)) {
            throw new NotFoundByIdException("There is no comment with ID: " + id + ", try again.");
        }
        deleteById(id);
    }
}
