package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.models.dto.response.ProductionMovieStudioResponseDto;
import com.kata.cinema.base.service.dto.ProductionMovieStudioResponseDtoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Api(tags = "Студии")
@AllArgsConstructor
public class ProductionStudioRestController {

    private final ProductionMovieStudioResponseDtoService productionMovieStudioResponseDtoService;

    @GetMapping("/{id}/studios")
    @ApiOperation(value = "Получение списка студий работавших над фильмом", response = ProductionMovieStudioResponseDto.class, responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка студий работавших над фильмом"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для просмотра контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<List<ProductionMovieStudioResponseDto>> getAllProductionStudiosMovie(@PathVariable Long id) {
        return new ResponseEntity<>(productionMovieStudioResponseDtoService.getProductionStudiosMovie(id), HttpStatus.OK);
    }
}
