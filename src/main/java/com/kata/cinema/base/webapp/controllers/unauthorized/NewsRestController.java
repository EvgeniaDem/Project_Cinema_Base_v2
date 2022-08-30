package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.service.abstracts.model.CommentsService;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@Api(tags = "Новости")
public class NewsRestController {
    private final CommentsService commentsService;
    private final NewsService newsService;

    public NewsRestController(CommentsService commentsService, NewsService newsService) {
        this.commentsService = commentsService;
        this.newsService = newsService;
    }

    @GetMapping("/latest")
    @ApiOperation(value = "Получение списка последних новостей", response = NewsTitleResponseDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка последних новостей"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<NewsTitleResponseDto>> getLatestNews() {
        return ResponseEntity.ok(newsService.getLatestNews());
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentsResponseDto>> getListOfComments(@PathVariable Long id) {
        if (newsService.isExistById(id)) {
            newsService.getById(id);
            return ResponseEntity.ok(commentsService.getComments(id));
        }
        throw new NotFoundByIdException("News with id: " + id + " does not exist, try looking for another");
    }
}
