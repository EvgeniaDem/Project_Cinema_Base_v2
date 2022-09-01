package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.response.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.entity.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/genres")
@Api(tags = "Жанры")
@AllArgsConstructor
public class AdminGenreRestController {

    private final GenreService genreService;


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

        Optional<Genres> optionalGenres = genreService.getById(id);
        if (optionalGenres.isEmpty()) {
            throw new NotFoundByIdException("There is no genre with ID: " + id + " , try again.");
        }
        Genres genres = optionalGenres.get();
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
