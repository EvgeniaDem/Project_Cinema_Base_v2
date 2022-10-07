package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;
import com.kata.cinema.base.service.entity.ExcertionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/excertions")
@Api(tags = "Выдержки")
@AllArgsConstructor
public class ExcertionRestController {

    private final ExcertionService excertionService;

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление выдержки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление выдержки"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления контента"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> deleteExcertion(@PathVariable Long id) {
        excertionService.deleteExcertionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновление выдержки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление выдержки"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления контента"),
            @ApiResponse(code = 404, message = "Невозможно найти")
    })
    public ResponseEntity<Void> putExcertion(@PathVariable Long id,
                                             @RequestBody ExcertionRequestDto excertionRequestDto) {
        excertionService.updateExcertion(excertionRequestDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
