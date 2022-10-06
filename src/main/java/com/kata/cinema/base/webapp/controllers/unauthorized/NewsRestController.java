package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsBodyResponseDto;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.dto.CommentDtoService;
import com.kata.cinema.base.service.dto.NewsDtoService;
import com.kata.cinema.base.service.dto.NewsResponseDtoPaginationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
@Api(tags = "Новости")
public class NewsRestController {
    private final CommentDtoService commentDtoService;
    private final NewsDtoService newsDtoService;
    private final NewsResponseDtoPaginationService newsResponseDtoPaginationService;

    public NewsRestController(CommentDtoService commentDtoService,
                              NewsDtoService newsDtoService,
                              @Qualifier("forNewsController") NewsResponseDtoPaginationService newsResponseDtoPaginationService) {
        this.commentDtoService = commentDtoService;
        this.newsDtoService = newsDtoService;
        this.newsResponseDtoPaginationService = newsResponseDtoPaginationService;
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
        return ResponseEntity.ok(newsDtoService.getLatestNews());
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentsResponseDto>> getListOfComments(@PathVariable Long id) {
        if (!newsDtoService.isExistById(id)) {
            throw new NotFoundByIdException("News with id: " + id + " does not exist, try looking for another");
        }
        return ResponseEntity.ok(commentDtoService.getComments(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsBodyResponseDto> getNewsBody(@PathVariable Long id) {
        if (!newsDtoService.isExistById(id)) {
            throw new NotFoundByIdException("News with id: " + id + " does not exist, try looking for another");
        }
        return new ResponseEntity<>(newsDtoService.getByIdNewsBodyPageInfo(id), HttpStatus.OK);
    }

    @GetMapping("/page/{pageNumber}")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Страница отсутствует или не существует указанных элементов"),
            @ApiResponse(code = 403, message = "Недостаточно прав доступа"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией"),
            @ApiResponse(code = 200, message = "Страница успешно найдена")
    })
    public ResponseEntity<PageDto<NewsResponseDto>> getPageOfNews(@PathVariable Integer pageNumber,
                                                                  @RequestParam(required = false, defaultValue = "10") Integer itemsOnPage,
                                                                  @RequestParam(required = false, defaultValue = "NEWS") Rubric rubric) {
        Map<String, Object> params = new HashMap<>();
        params.put("rubric", rubric);
        return ResponseEntity.ok(newsResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, params));
    }
}
