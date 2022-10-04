package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.RatingCommentResponseDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.models.entitys.RatingComment;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.TypeRating;
import com.kata.cinema.base.service.dto.CommentDtoService;
import com.kata.cinema.base.service.entity.RatingCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/comment")
@AllArgsConstructor
public class UserCommentRestController {

    private final CommentDtoService commentDtoService;
    private final RatingCommentService ratingCommentService;

    @PatchMapping("/{id}")
    public ResponseEntity<Void> addReaction(@PathVariable Long id, @RequestParam("typeRating")TypeRating typeRating) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        if (auth != null) {
            if (auth.getPrincipal() instanceof UserDetails) {
                user = (User) auth.getPrincipal();
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

        Long userId = user.getId();
        Optional<Comment> commentOptional = commentDtoService.getById(id);
        if (commentOptional.isEmpty()) {
            throw new NotFoundByIdException("You entered incorrect data, try again or contact support");
        }

        List<RatingCommentResponseDto> ratingCommentResponseDto = ratingCommentService.getRatingByCommentIdAndUserId(id, userId);

        RatingComment ratingComment;

        if (ratingCommentResponseDto.size() == 0) {
            ratingComment = new RatingComment();
            ratingComment.setComment(commentOptional.get());
            ratingComment.setUser(user);
            ratingComment.setRating(typeRating);
            ratingCommentService.create(ratingComment);
        } else {
            Long ratingId = ratingCommentResponseDto.get(0).getId();
            Optional<RatingComment> ratingCommentOptional = ratingCommentService.getById(ratingId);
            if (ratingCommentOptional.isEmpty()) {
                throw new NotFoundByIdException("There is no rating with ID: " + id + " , try again.");
            }
            if (!ratingCommentOptional.get().getRating().equals(typeRating)) {
                ratingComment = ratingCommentOptional.get();
                ratingComment.setRating(typeRating);
                ratingCommentService.update(ratingComment);
            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
