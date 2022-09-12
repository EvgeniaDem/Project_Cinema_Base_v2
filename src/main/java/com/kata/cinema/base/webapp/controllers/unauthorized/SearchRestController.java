package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.dto.response.SearchMovieResponseDto;
import com.kata.cinema.base.models.dto.response.SearchResponseDto;
import com.kata.cinema.base.models.dto.response.SearchUserResponseDto;
import com.kata.cinema.base.models.enums.MovieSortType;
import com.kata.cinema.base.service.dto.SearchMovieResponseDtoPaginationService;
import com.kata.cinema.base.service.abstracts.model.PersonsService;
import com.kata.cinema.base.service.dto.SearchUserDtoService;
import com.kata.cinema.base.service.entity.CollectionService;
import com.kata.cinema.base.service.entity.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
@Api(tags = "Поиск")
@AllArgsConstructor
public class SearchRestController {

    private final SearchUserDtoService searchUserService;
    private final SearchMovieResponseDtoPaginationService searchMovieResponseDtoPaginationService;
    private final MovieService movieService;
    private final CollectionService collectionsService;
    private final PersonsService personsService;

    @GetMapping("/users")
    @ApiOperation(value = "Получение списка пользователей с помощью почты", response = SearchUserResponseDto.class, responseContainer = "list")
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

    @GetMapping
    public ResponseEntity<SearchResponseDto> searchHeader(@RequestParam String filterPattern) {

        List<SearchMovieDto> searchMovieDtoList = movieService.getSearchMoviesWithFilter(filterPattern);
        List<SearchCollectionDto> searchCollectionDtoList = collectionsService.getSearchCollectionWithFilter(filterPattern);
        List<SearchPersonDto> searchPersonDtoList = personsService.getSearchPersonWithFilter(filterPattern);

        return new ResponseEntity<>(new SearchResponseDto(searchMovieDtoList, searchCollectionDtoList,searchPersonDtoList), HttpStatus.OK);
    }
}
