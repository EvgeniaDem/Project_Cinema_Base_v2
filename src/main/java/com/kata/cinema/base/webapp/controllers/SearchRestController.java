package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.dao.abstracts.dto.SearchUserDao;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.models.dto.response.SearchMovieResponseDto;
import com.kata.cinema.base.models.enums.MovieSortType;
import com.kata.cinema.base.service.abstracts.dto.SearchMovieResponseDtoPaginationService;
import com.kata.cinema.base.service.abstracts.model.SearchUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
@Api(tags = "Поиск")
public class SearchRestController {

    private final SearchUserService searchUserService;
    SearchMovieResponseDtoPaginationService searchMovieResponseDtoPaginationService;

    @Autowired
    public SearchRestController(SearchUserService searchUserService, SearchMovieResponseDtoPaginationService paginationDtoService) {
        this.searchUserService = searchUserService;
        this.searchMovieResponseDtoPaginationService = paginationDtoService;
    }

    @GetMapping("/users")
    @ApiOperation(value = "Получение списка пользователей с помощью почты", response = SearchUserDao.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка пользователей"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<SearchUserResponseDto>> getUserByMail(
            @RequestParam(name = "email") String email) {
        List<SearchUserResponseDto> users = searchUserService.findSearchUserByEmail(email);
        return users.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(users);
    }


    @GetMapping("/movies/page/{pageNumber}")
    @ApiOperation(value = "Получение фильма", response = SearchMovieResponseDto.class, responseContainer = "pageDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение фильма"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")

    })
    ResponseEntity<PageDto<SearchMovieResponseDto>> getMovies(@PathVariable Integer pageNumber,
                                                              @RequestParam(required = false, defaultValue = "10") Integer itemsOnPage, @RequestParam String name,
                                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                              @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                              @RequestParam(required = false) List<String> genres, @RequestParam(required = false) Integer rars,
                                                              @RequestParam(required = false) Integer mpaa,
                                                              @RequestParam(required = false, defaultValue = "DATE_RELEASE_ASC") MovieSortType sortType) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);
        parameters.put("genres", genres);
        parameters.put("rars", rars);
        parameters.put("mpaa", mpaa);
        parameters.put("sortType", sortType);

        return ResponseEntity.ok(searchMovieResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, parameters));
    }
}
