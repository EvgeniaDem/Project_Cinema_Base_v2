package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.service.abstracts.dto.FolderMovieDtoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/foldermovies")
public class UserFolderMovieRestController {

    private final FolderMovieDtoService folderMovieDtoService;

    public UserFolderMovieRestController(FolderMovieDtoService folderMovieDtoService) {
        this.folderMovieDtoService = folderMovieDtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FolderMovieDto> getOneFolderMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(folderMovieDtoService.getById(id));
    }

    @GetMapping("/userId")
    public ResponseEntity<List<FolderMovieDto>> getByUserId(Long userId) {
        return ResponseEntity.ok(folderMovieDtoService.getAllByUserId(userId));
    }

}
