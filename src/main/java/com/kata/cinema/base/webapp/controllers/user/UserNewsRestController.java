package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.CommentDtoService;
import com.kata.cinema.base.service.dto.NewsDtoService;
import com.kata.cinema.base.service.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/news")
@AllArgsConstructor
public class UserNewsRestController {
    private final NewsDtoService newsDtoService;
    private final UserService userService;
    private final CommentDtoService commentDtoService;

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentsRequestDto> addComments(
            @PathVariable Long id,
            @RequestBody CommentsRequestDto commentsRequestDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        if (auth != null) {
            if (auth.getPrincipal() instanceof UserDetails) {
                user = (User) auth.getPrincipal();
            }
        }
        Long userId = user.getId();
        Comment comments = new Comment();
        comments.setDate(LocalDateTime.now());

        Optional<News> news = newsDtoService.getById(id);
        Optional<User> userOptional = userService.getById(userId);
        if (news.isEmpty() || userOptional.isEmpty()) {
            throw new NotFoundByIdException("You entered incorrect data, try again or contact support");
        }
        comments.setNews(news.get());
        comments.setUser(userOptional.get());
        commentDtoService.create(comments);
        return new ResponseEntity<>(commentsRequestDto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}/comments")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (commentDtoService.isExistById(id)) {
            commentDtoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
    }

    @PutMapping("/{id}/comments")
    public ResponseEntity<Void> updateComment(@PathVariable Long id, @RequestBody CommentsRequestDto commentsRequestDto) {
        Optional<Comment> commentOptional = commentDtoService.getById(id);
        if (commentOptional.isEmpty()) {
            throw new NotFoundByIdException("You entered incorrect data, try again or contact support");
        }

        Comment updateComment = commentOptional.get();
        updateComment.setMessage(commentsRequestDto.getMessage());
        commentDtoService.update(updateComment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
