package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.dao.entity.ScoreDao;
import com.kata.cinema.base.models.MovieScoreRequest;
import com.kata.cinema.base.models.MovieScoreResponse;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.entity.ScoreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieRatingController {

    private final ScoreService scoreService;

    @PostMapping("/create-rating")
    @ApiOperation(value = "Добавление оценки фильму", notes = "Один юзер может выставить только одну оценку фильму")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все прошло успешно"),
            @ApiResponse(code = 401, message = "Такого фильма нет в списке"),
            @ApiResponse(code = 402, message = "Вы уже оценивали фильм"),
            @ApiResponse(code = 403, message = "Оценка находится за пределами допустимого диапазона")
    })
    public ResponseEntity<MovieScoreResponse> addRating(@RequestBody MovieScoreRequest movieScoreRequest, @AuthenticationPrincipal User user) {
        log.info("Получен фильм: {}, user: {}", movieScoreRequest, user);
        MovieScoreResponse response = scoreService.createRating(movieScoreRequest, user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


/*    @DeleteMapping("/delete/{movieId}")
    @ApiOperation(value = "Удаление оценки фильма")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все прошло успешно"),
            @ApiResponse(code = 401, message = "Такого фильма нет в списке")
    })
    public ResponseEntity<Void> deleteRating(@PathVariable Long movieId, @AuthenticationPrincipal User user) {
        scoreDao.deleteScore(movieId, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/


/*    @PatchMapping("/movies/{id}")
    @ApiOperation(value = "Изменение оценки фильма")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Все прошло успешно"),
            @ApiResponse(code = 401, message = "Такого фильма нет в списке"),
            @ApiResponse(code = 403, message = "Оценка находится за пределами допустимого диапазона")
    })
    public ResponseEntity<Void> updateRating(@PathVariable Long movieId, @AuthenticationPrincipal User user){
        scoreDao.updateScore(movieId, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
