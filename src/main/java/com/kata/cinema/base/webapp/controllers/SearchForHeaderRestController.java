package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.response.SearchResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchForHeaderRestController {

    @GetMapping("")
    public ResponseEntity<SearchResponseDto> searchHeader(){
        return null;
    }
}
