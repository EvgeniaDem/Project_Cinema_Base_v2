package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.TopMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.MovieReleaseResponseDto;
import com.kata.cinema.base.models.enums.TopMoviesType;
import com.kata.cinema.base.service.abstracts.dto.TopMoviesResponseDtoPaginationService;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@Api(tags = "Фильмы")
public class MovieRestController {

    private final MovieService movieService;
    private final TopMoviesResponseDtoPaginationService topMoviesResponseDtoPaginationService;

    public MovieRestController(MovieService movieService, TopMoviesResponseDtoPaginationService topMoviesResponseDtoPaginationService) {
        this.movieService = movieService;
        this.topMoviesResponseDtoPaginationService = topMoviesResponseDtoPaginationService;
    }

    @GetMapping("/release")
    @ApiOperation(value = "Получение списка вышедших фильмов", response = MovieRestController.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка вышедших фильмов"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    ResponseEntity<List<MovieReleaseResponseDto>> getReleaseFilms() {
        return ResponseEntity.ok(movieService.getReleaseFilms());
    }

    @GetMapping("/top")
    @ApiOperation(value = "Получение списка лучших фильмов", response = TopMoviesResponseDto.class, responseContainer = "pageDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка лучших фильмов"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    ResponseEntity<PageDto<TopMoviesResponseDto>> getTopMovies(@RequestParam(required = false) Integer pageNumber,
                                                               @RequestParam(required = false, defaultValue = "50") Integer itemsOnPage,
                                                               @RequestParam(required = false, defaultValue = "250") Integer count,
                                                               @RequestParam(required = false, defaultValue = "ORDER") TopMoviesType topMoviesType,
                                                               @RequestParam(required = false, name = "genres") List<Integer> genreId,
                                                               @RequestParam(required = false)
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                               @RequestParam(required = false)
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("count", count);
        parameters.put("topMoviesType", topMoviesType);
        parameters.put("genres", genreId);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);

        return ResponseEntity.ok(topMoviesResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, parameters));
    }
}
