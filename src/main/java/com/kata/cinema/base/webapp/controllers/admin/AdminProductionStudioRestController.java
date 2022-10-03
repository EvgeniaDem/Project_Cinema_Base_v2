package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.converter.ProductionStudioMapper;
import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;
import com.kata.cinema.base.models.entitys.ProductionStudio;
import com.kata.cinema.base.service.entity.ProductionStudioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/studios")
@Api(tags = "Студии")
@AllArgsConstructor
public class AdminProductionStudioRestController {

    private final ProductionStudioMapper productionStudioMapper;
    private final ProductionStudioService productionStudioService;

    @PostMapping
    @ApiOperation(value = "Добавление студии")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное добавление студии"),
            @ApiResponse(code = 201, message = "Успешное добавление студии"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для создания контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<Void> createProductionStudio(@RequestBody ProductionStudioRequestDto productionStudioRequestDto) {
        productionStudioService.create(productionStudioMapper.toProductionStudio(productionStudioRequestDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаление студии")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление студии"),
            @ApiResponse(code = 201, message = "Успешное удаление студии"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<Void> deleteProductionStudio(@PathVariable Long id) {
        if (!productionStudioService.isExistById(id)) {
            throw new NotFoundByIdException("There is no production studio with ID: " + id + ", try again.");
        }
        productionStudioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновление студии")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление студии"),
            @ApiResponse(code = 201, message = "Успешное обновление студии"),
            @ApiResponse(code = 401, message = "Проблема с аутентификацией или авторизацией на сайте"),
            @ApiResponse(code = 403, message = "Недостаточно прав для удаления контента"),
            @ApiResponse(code = 404, message = "Невозможно найти.")
    })
    public ResponseEntity<Void> putProductionStudio(@PathVariable Long id,
                                                    @RequestBody ProductionStudioRequestDto productionStudioRequestDto) {
        if (!productionStudioService.isExistById(id)) {
            throw new NotFoundByIdException("There is no production studio with ID: " + id + ", try again.");
        }
        ProductionStudio productionStudio = productionStudioMapper.toProductionStudio(productionStudioRequestDto);
        productionStudio.setId(id);
        productionStudioService.update(productionStudio);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
