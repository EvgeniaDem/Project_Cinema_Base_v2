package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.*;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.ReviewSortType;
import com.kata.cinema.base.models.enums.TopMoviesType;
import com.kata.cinema.base.models.enums.TypeReview;
import com.kata.cinema.base.service.dto.*;
import com.kata.cinema.base.service.entity.ReactionReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@Api(tags = "Фильмы")
@AllArgsConstructor
public class MovieRestController {

    private final MovieDtoService movieDtoService;
    private final TopMoviesResponseDtoPaginationService topMoviesResponseDtoPaginationService;
    private final ReviewMovieResponseDtoPaginationService reviewsResponseDtoPaginationService;
    private final MovieViewResponseDtoService movieViewResponseDtoService;
    private final ReviewMovieResponseDtoService reviewMovieResponseDtoService;
    private final ReactionReviewService reactionReviewService;

    @GetMapping("/release")
    @ApiOperation(value = "Получение списка вышедших фильмов", response = MovieRestController.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка вышедших фильмов"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    ResponseEntity<List<MovieReleaseResponseDto>> getReleaseFilms() {
        return ResponseEntity.ok(movieDtoService.getReleaseFilms());
    }

    @GetMapping("/top/page/{pageNumber}")
    @ApiOperation(value = "Получение списка лучших фильмов", response = TopMoviesResponseDto.class, responseContainer = "pageDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка лучших фильмов"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    ResponseEntity<PageDto<TopMoviesResponseDto>> getTopMovies(@PathVariable Integer pageNumber,
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


    @GetMapping("/{id}/reviews/page/{pageNumber}")
    ResponseEntity<ReviewMovieResponseDto> getReviews(@PathVariable Long id,
                                                      @PathVariable Integer pageNumber,
                                                      @RequestParam(required = false, defaultValue = "10") Integer itemsOnPage,
                                                      @RequestParam(required = false) TypeReview typeReview,
                                                      @RequestParam(required = false, defaultValue = "DATE_ASC") ReviewSortType reviewSortType) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("typeReview", typeReview);
        parameters.put("sortType", reviewSortType);
        return ResponseEntity.ok(reviewMovieResponseDtoService.getReviewMovieResponseDto(id, pageNumber, itemsOnPage, parameters));
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Получение фильма")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Фильм успешно получен"),
            @ApiResponse(code = 403, message = "Недостаточно прав доступа "),
            @ApiResponse(code = 401, message = "Проблема с авторизацией или аутентификацией")
    })
    public ResponseEntity<MovieViewResponseDto> getMovieViewResponseDto(@PathVariable Long id, @AuthenticationPrincipal User user) {
        if (!movieDtoService.isExistById(id)) throw new NotFoundByIdException("Не существует такое кино");
        return ResponseEntity.ok(movieViewResponseDtoService.getMovieViewResponseDtoById(id, user));
    }
}
