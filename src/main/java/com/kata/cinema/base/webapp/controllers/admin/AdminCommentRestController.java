package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.service.dto.CommentsResponseDtoPaginationService;
import com.kata.cinema.base.service.entity.CommentService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/comments")
@Api(tags = "Комментарии")
@AllArgsConstructor
public class AdminCommentRestController {

    private final CommentsResponseDtoPaginationService commentsResponseDtoPaginationService;

    private final CommentService commentService;

    @GetMapping("/moderator/page/{pageNumber}")
    @ApiOperation(value = "Получение страницы комментариев с isModerate == false", response = CommentsResponseDto.class, responseContainer = "pageDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение страницы комментариев с isModerate == false"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<PageDto<CommentsResponseDto>> getNonModeratedComments(
            @ApiParam(value = "Номер страницы") @PathVariable Integer pageNumber,
            @ApiParam(value = "Комментариев на странице") @RequestParam Integer itemsOnPage) {
        return ResponseEntity.ok(commentsResponseDtoPaginationService.getPageDto(pageNumber, itemsOnPage));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление комментария")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комментарий успешно удалён"),
            @ApiResponse(code = 400, message = "По переданному id, комментария не найдено"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента")
    })
    public ResponseEntity<Void> deleteCommentById(
            @ApiParam(value = "id комментария") @PathVariable Long id) {
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/moderator")
    @ApiOperation(value = "Меняет флаг isModerate на true")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Флаг успешно изменён."),
            @ApiResponse(code = 400, message = "По переданному id, комментария не найдено"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента")
    })
    public ResponseEntity<Void> updateIsModerateToTrueById(
            @ApiParam(value = "id комментария") @PathVariable Long id) {
        commentService.updateIsModerateToTrueById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
