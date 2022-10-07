package com.kata.cinema.base.dao.entity.impl;

import com.kata.cinema.base.dao.entity.RatingCommentDao;
import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.models.entitys.RatingComment;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.TypeRating;
import com.kata.cinema.base.service.dto.CommentDtoService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class RatingCommentDaoImpl extends AbstractDaoImpl<Long, RatingComment> implements RatingCommentDao {

    private final CommentDtoService commentDtoService;

    public RatingCommentDaoImpl(CommentDtoService commentDtoService) {
        this.commentDtoService = commentDtoService;
    }

    @Override
    public List<RatingCommentResponseDto> getRatingByCommentIdAndUserId(Long commentId, Long userId) {
        return entityManager.createQuery(
                        "select new com.kata.cinema.base.models.dto.response.RatingCommentResponseDto(" +
                                " rc.id, rc.rating) from RatingComment rc where rc.comment.id=:commentId and rc.user.id = :userId", RatingCommentResponseDto.class)
                .setParameter("commentId", commentId)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    @Transactional
    public void patchComment(Long idComment, User user, TypeRating typeRating) {
        Long userId = user.getId();
        Optional<Comment> commentOptional = commentDtoService.getById(idComment);
        if (commentOptional.isEmpty()) {
            throw new NotFoundByIdException("You entered incorrect data, try again or contact support");
        }
        List<RatingCommentResponseDto> ratingCommentResponseDto = getRatingByCommentIdAndUserId(idComment, userId);

        RatingComment ratingComment;

        if (ratingCommentResponseDto.size() == 0) {
            ratingComment = new RatingComment();
            ratingComment.setComment(commentOptional.get());
            ratingComment.setUser(user);
            ratingComment.setRating(typeRating);
            create(ratingComment);
        } else {
            Long ratingId = ratingCommentResponseDto.get(0).getId();
            Optional<RatingComment> ratingCommentOptional = getById(ratingId);
            if (ratingCommentOptional.isEmpty()) {
                throw new NotFoundByIdException("There is no rating with ID: " + idComment + " , try again.");
            }
            if (!ratingCommentOptional.get().getRating().equals(typeRating)) {
                ratingComment = ratingCommentOptional.get();
                ratingComment.setRating(typeRating);
                update(ratingComment);
            }
        }
    }
}
