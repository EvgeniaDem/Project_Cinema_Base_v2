package com.kata.cinema.base.webapp.controllers.publicist;

import com.kata.cinema.base.converter.NewsMapper;
import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/publicist/news")
@Api(tags = "Новости")
public class PublicistNewsRestController {

    private final NewsService newsService;
    private final NewsMapper newsMapper;

    @Autowired
    public PublicistNewsRestController(NewsService newsService, NewsMapper newsMapper) {
        this.newsService = newsService;
        this.newsMapper = newsMapper;
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Получение списка новостей", response = NewsResponseDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка новостей"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<NewsResponseDto>> getNews(@RequestParam(name = "startDate", required = false)
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @RequestParam(name = "endDate", required = false)
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                         @RequestParam(name = "rubric", required = false) Rubric rubric) {
        return ResponseEntity.ok(newsService.findByDateBetweenAndRubric(startDate, endDate, rubric));
    }

    @PostMapping
    @ApiOperation(value = "Создание новости", response = NewsRequestDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление новости"),
            @ApiResponse(code = 201, message = "Успешное добавление новости"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<NewsRequestDto> createNews(@RequestBody NewsRequestDto newsRequestDto) {
        News news = newsMapper.toNews(newsRequestDto);
        news.setDate(LocalDate.now());
        newsService.save(news);
        return new ResponseEntity<>(newsRequestDto, HttpStatus.CREATED);
    }

}
