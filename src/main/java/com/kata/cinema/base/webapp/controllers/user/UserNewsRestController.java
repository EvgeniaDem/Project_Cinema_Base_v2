package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import com.kata.cinema.base.models.entitys.Comment;
import com.kata.cinema.base.service.dto.CommentDtoService;
import com.kata.cinema.base.service.dto.NewsDtoService;
import com.kata.cinema.base.service.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user/news")
@AllArgsConstructor
public class UserNewsRestController {
    private final NewsDtoService newsDtoService;
    private final UserService userService;
    private final CommentDtoService commentDtoService;

    @PostMapping("/{id}/comments")
    //TODO убрать userId, доставать из сеьюритит контекста
    public ResponseEntity<CommentsRequestDto> addComments(
            @PathVariable Long id, @RequestParam Long userId,
            @RequestBody CommentsRequestDto commentsRequestDto) {
        Comment comments = new Comment();
        comments.setDate(LocalDateTime.now());

        //TODO в ифе выкидывать есепшинал
        if (newsDtoService.isExistById(id) && userService.isExistById(userId)) {
            comments.setNews(newsDtoService.getById(id).orElseThrow());
            comments.setUser(userService.getById(userId).orElseThrow());
            commentDtoService.create(comments);
            return new ResponseEntity<>(commentsRequestDto, HttpStatus.OK);
        }
        throw new NotFoundByIdException("You entered incorrect data, try again or contact support");
    }
}
