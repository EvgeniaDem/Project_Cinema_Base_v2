package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.service.dto.FolderMovieDtoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/foldermovies")
@AllArgsConstructor
public class UserFolderMovieRestController {

    private final FolderMovieDtoService folderMovieDtoService;

    @GetMapping("/{id}")
    public ResponseEntity<FolderMovieDto> getOneFolderMovies(@PathVariable("id") Long id) {
        return ResponseEntity.ok(folderMovieDtoService.getById(id));
    }

    @GetMapping("/userId")
    public ResponseEntity<List<FolderMovieDto>> getByUserId(Long userId) {
        return ResponseEntity.ok(folderMovieDtoService.getAllByUserId(userId));
    }

}
