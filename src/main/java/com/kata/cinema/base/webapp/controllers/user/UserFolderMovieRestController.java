package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.dto.FolderMovieDto;
import com.kata.cinema.base.models.dto.response.FolderResponseDto;
import com.kata.cinema.base.models.entitys.FolderMovie;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.service.dto.FolderMovieDtoService;
import com.kata.cinema.base.service.entity.FolderMoviesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.kata.cinema.base.models.enums.Category.CUSTOM;
import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;

@RestController
@RequestMapping("/api/user/folders")
@AllArgsConstructor
public class UserFolderMovieRestController {

    private FolderMoviesService folderMoviesService;
    private FolderMovieDtoService folderMovieDtoService;

    @GetMapping()
    public ResponseEntity< List<FolderResponseDto>> getFolderMovieResponseDto(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<FolderMovieDto> folderMovie = folderMovieDtoService.getAllByUserId(user.getId());
        List<FolderResponseDto> folderResponseDtos = new ArrayList<>();
        for(FolderMovieDto fi: folderMovie){
            FolderResponseDto folderResponseDto = new FolderResponseDto(fi.getId(), fi.getName(),fi.getCategory(),folderMovie.size());
            folderResponseDtos.add(folderResponseDto);
        }
        return ResponseEntity.ok(folderResponseDtos);
    }


    @PostMapping()
    public ResponseEntity<FolderMovie> addNewFolderMovie(@RequestBody FolderMovie folderMovie){
        folderMovie.setCategory(CUSTOM);
        folderMovie.setPrivacy(PUBLIC);
        if (folderMovie.getName()==null){
            folderMovie.setName("Новый список");
        }
        folderMoviesService.create(folderMovie);
        return new ResponseEntity<>(folderMovie, HttpStatus.CREATED);
    }
}
