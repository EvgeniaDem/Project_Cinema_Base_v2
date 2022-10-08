package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;
import com.kata.cinema.base.models.dto.response.ExcertionResponseDto;
import com.kata.cinema.base.service.dto.ExcertionResponseDtoPaginationService;
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
@RequestMapping("/api/persons")
@Api(tags = "Персоны")
@AllArgsConstructor
public class PersonRestController {

    private final ExcertionResponseDtoPaginationService excertionResponseDtoPaginationService;
    private final ExcertionService excertionService;

    @GetMapping("/{id}/excertions/page/{pageNumber}")
    @ApiOperation(value = "Получение выдержек персоны")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Выдержки персоны успешно получены"),
            @ApiResponse(code = 401, message = "Проблема с авторизацией или аутентикацией"),
            @ApiResponse(code = 403, message = "Недостаточно прав доступа "),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<PageDto<ExcertionResponseDto>> getExcertionResponseDto(@PathVariable Long id,
                                                                                 @PathVariable Integer pageNumber,
                                                                                 @RequestParam Integer itemsOnPage) {
        return ResponseEntity.ok(excertionResponseDtoPaginationService
                .getPaginationExcertionResponseDtoForPerson(id, pageNumber, itemsOnPage));
    }

    @PostMapping("{id}/excertions")
    @ApiOperation(value = "Добавление выдержки персоны")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление выдержки персоны"),
            @ApiResponse(code = 201, message = "Успешное добавление выдержки персоны"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<Void> createExcertion(@RequestBody ExcertionRequestDto excertionRequestDto,
                                                @PathVariable Long id) {
        excertionService.createExcertionWithPersonId(excertionRequestDto, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

