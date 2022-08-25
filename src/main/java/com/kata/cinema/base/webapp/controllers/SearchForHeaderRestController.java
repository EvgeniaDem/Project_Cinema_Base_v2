package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.response.SearchResponseDto;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchForHeaderRestController {
    private MovieService movieService;

    public SearchForHeaderRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/search/forHeader")
    public ResponseEntity searchHeader(@RequestParam String filterPattern){


         return new ResponseEntity<>(movieService.getSearchMoviesWithFilter(filterPattern), HttpStatus.OK);
    }
}
