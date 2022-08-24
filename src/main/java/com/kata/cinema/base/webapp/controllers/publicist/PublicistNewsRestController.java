package com.kata.cinema.base.webapp.controllers.publicist;

import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/publicist/news")
public class PublicistNewsRestController {

    private final NewsService newsService;
    private final ConversionService conversionService;

    public PublicistNewsRestController(NewsService newsService, ConversionService conversionService) {
        this.newsService = newsService;
        this.conversionService = conversionService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<NewsResponseDto>> getNews(@RequestParam(name = "startDate", required = false)
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                         @RequestParam(name = "endDate", required = false)
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                         @RequestParam(name = "rubric", required = false) Rubric rubric) {
        return ResponseEntity.ok(newsService.findByDateBetweenAndRubric(startDate, endDate, rubric));
    }

    @PostMapping
    public ResponseEntity<NewsRequestDto> createNews(@RequestBody NewsRequestDto newsRequestDto) {
        News news = convertToNews(newsRequestDto);
        news.setDate(LocalDate.now());
        newsService.save(news);
        return new ResponseEntity<>(newsRequestDto, HttpStatus.CREATED);
    }

    //TODO использовать ResponseEntity и MapStruct
    private News convertToNews(NewsRequestDto dto) {
        return conversionService.convert(dto, News.class);
    }

}
