package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/genres")
@Api(tags = "Жанры")
public class AdminGenreRestController {
    private final GenreService genreService;

    @Autowired
    public AdminGenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    @ApiOperation(value = "Получение жанров", response = GenreResponseDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка жанров"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")

    })
    public ResponseEntity<List<GenreResponseDto>> getGenres() {
        return ResponseEntity.ok(genreService.findGenres());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление жанра", response = GenreResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Жанр успешно удалён"),
            @ApiResponse(code = 204, message = "Сервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(code = 400, message = "По переданному id, жанра не найдено"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента")
    })
    public ResponseEntity<GenreResponseDto> deleteGenres(@ApiParam(value = "id жанра") @PathVariable Long id) {
        if (!genreService.isExistById(id)) {
            throw new NotFoundByIdException("There is no genre with ID: " + id + " , try again.");
        }
        genreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменение жанра", response = GenreResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Жанр успешно изменён."),
            @ApiResponse(code = 201, message = "Жанр выполнен успешно и привёл к созданию ресурса"),
            @ApiResponse(code = 400, message = "Ошибка. Изменить не получилось.")
    })
    public ResponseEntity<GenreResponseDto> update(
            @ApiParam(value = "id жанра") @PathVariable Long id,
            @ApiParam(value = "name жанра") @RequestParam String name) {

        if (!genreService.isExistById(id)) {
            throw new NotFoundByIdException("There is no genre with ID: " + id + " , try again.");
        }
        Genres genres = genreService.getById(id).orElseThrow();
        genres.setName(name);
        genreService.update(genres);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "Добавление жанра", response = GenreResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление жанра"),
            @ApiResponse(code = 201, message = "Успешное создание жанра"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<GenreResponseDto> addGenre(
            @ApiParam(value = "name жанра") @RequestParam String name) {
        genreService.create(new Genres(name));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
