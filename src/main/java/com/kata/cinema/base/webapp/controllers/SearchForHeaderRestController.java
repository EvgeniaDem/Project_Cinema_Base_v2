package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.SearchCollectionDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.models.dto.SearchPersonDto;
import com.kata.cinema.base.models.dto.response.SearchResponseDto;
import com.kata.cinema.base.service.abstracts.model.CollectionsService;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import com.kata.cinema.base.service.abstracts.model.PersonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchForHeaderRestController {
    private MovieService movieService;
    private CollectionsService collectionsService;
    private PersonsService personsService;

    public SearchForHeaderRestController(MovieService movieService, CollectionsService collectionsService, PersonsService personsService) {
        this.movieService = movieService;
        this.collectionsService = collectionsService;
        this.personsService = personsService;
    }


    @GetMapping("/api/search/")
    public ResponseEntity<SearchResponseDto> searchHeader(@RequestParam String filterPattern) {

        List<SearchMovieDto> searchMovieDtoList = movieService.getSearchMoviesWithFilter(filterPattern);
        List<SearchCollectionDto> searchCollectionDtoList = collectionsService.getSearchCollectionWithFilter(filterPattern);
        List<SearchPersonDto> searchPersonDtoList = personsService.getSearchPersonWithFilter(filterPattern);

        return new ResponseEntity<>(new SearchResponseDto(searchMovieDtoList, searchCollectionDtoList,searchPersonDtoList), HttpStatus.OK);
    }
}
