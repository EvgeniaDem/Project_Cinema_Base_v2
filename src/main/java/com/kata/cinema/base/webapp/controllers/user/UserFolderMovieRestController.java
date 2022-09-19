package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.MovieResponseDto;
import com.kata.cinema.base.models.enums.ShowType;
import com.kata.cinema.base.models.enums.SortMovieFolderType;
import com.kata.cinema.base.models.dto.response.FolderResponseDto;
import com.kata.cinema.base.models.entitys.FolderMovie;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.FolderMovieDtoService;
import com.kata.cinema.base.service.dto.MovieResponseDtoPaginationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.kata.cinema.base.service.entity.FolderMoviesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.kata.cinema.base.models.enums.Category.CUSTOM;
import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;

@RestController
@RequestMapping("/api/user/folders")
@AllArgsConstructor
public class UserFolderMovieRestController {

    private final FolderMovieDtoService folderMovieDtoService;
    private final MovieResponseDtoPaginationService movieResponseDtoPaginationService;
    private FolderMoviesService folderMoviesService;
    private FolderMovieDtoService folderMovieDtoService;

    @GetMapping
    public ResponseEntity<List<FolderResponseDto>> getFolderMovieResponseDto() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<FolderMovieDto> folderMovie = folderMovieDtoService.getAllByUserId(user.getId());
        List<FolderResponseDto> folderResponseDtos = new ArrayList<>();
        for (FolderMovieDto fi : folderMovie) {
            FolderResponseDto folderResponseDto = new FolderResponseDto(fi.getId(), fi.getName(), fi.getCategory(), folderMovie.size());
            folderResponseDtos.add(folderResponseDto);
        }
        return ResponseEntity.ok(folderResponseDtos);
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

    @PostMapping
    public ResponseEntity<FolderMovie> addNewFolderMovie(@RequestBody FolderMovie folderMovie) {
        folderMovie.setCategory(CUSTOM);
        folderMovie.setPrivacy(PUBLIC);
        if (folderMovie.getName() == null) {
            folderMovie.setName("Новый список");
        }
        folderMoviesService.create(folderMovie);
        return new ResponseEntity<>(folderMovie, HttpStatus.CREATED);
    }
}
