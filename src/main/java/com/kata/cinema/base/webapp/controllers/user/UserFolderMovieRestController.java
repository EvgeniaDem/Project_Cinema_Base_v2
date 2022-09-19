package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.enums.ShowType;
import com.kata.cinema.base.models.enums.SortMovieFolderType;
import com.kata.cinema.base.service.dto.FolderMovieDtoService;
import com.kata.cinema.base.service.dto.MovieResponseDtoPaginationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/folders")
@AllArgsConstructor
public class UserFolderMovieRestController {

    private final FolderMovieDtoService folderMovieDtoService;
    private final MovieResponseDtoPaginationService movieResponseDtoPaginationService;

    @GetMapping("/{id}")
    public ResponseEntity<FolderMovieDto> getOneFolderMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(folderMovieDtoService.getById(id));
    }

    @GetMapping("/userId")
    public ResponseEntity<List<FolderMovieDto>> getByUserId(Long userId) {
        return ResponseEntity.ok(folderMovieDtoService.getAllByUserId(userId));
    }

    @GetMapping("/{id}/movies/page/{pageNumber}")
    @ApiOperation(value = "Получение страницы фильмов", response = MovieResponseDto.class, responseContainer = "pageDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение страницы фильмов"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    ResponseEntity<PageDto<MovieResponseDto>> getUserFolderMovies(
            @PathVariable("id") Long id,
            @PathVariable("pageNumber") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "10") Integer itemsOnPage,
            @RequestParam(required = false, defaultValue = "ORDER") SortMovieFolderType sortMovieFolder,
            @RequestParam(required = false, defaultValue = "ALL") ShowType showType) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("sortMovieFolderType", sortMovieFolder);
        parameters.put("showType", showType);
        return ResponseEntity.ok(movieResponseDtoPaginationService.getPageDtoWithParameters(pageNumber, itemsOnPage, parameters));
    }
}
