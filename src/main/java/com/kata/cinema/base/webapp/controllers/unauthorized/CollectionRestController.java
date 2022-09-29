package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.request.CollectionRequestDto;
import com.kata.cinema.base.models.dto.response.CollectionMoviesResponseDto;
import com.kata.cinema.base.models.dto.response.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.models.enums.СollectionSortType;
import com.kata.cinema.base.service.dto.CollectionMoviesResponseDtoService;
import com.kata.cinema.base.service.entity.CollectionService;
import com.kata.cinema.base.service.entity.MovieService;
import com.kata.cinema.base.service.dto.CollectionDtoService;
import com.kata.cinema.base.service.entity.FolderMoviesService;
import com.kata.cinema.base.service.dto.MovieDtoService;
import com.kata.cinema.base.service.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.*;


@RestController
@RequestMapping("/api/collections")
@AllArgsConstructor
public class CollectionRestController {

    private final CollectionService collectionService;
    private final MovieService movieService;

    private final CollectionMoviesResponseDtoService collectionMoviesResponseDtoService;

    private final CollectionDtoService collectionDtoService;
    private final FolderMoviesService folderMoviesService;
    private final MovieDtoService movieDtoService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<CollectionResponseDto>> getCollectionResponseDto(@RequestParam(defaultValue = "MOVIES") CollectionType type) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        if (auth != null) {
            if (auth.getPrincipal() instanceof UserDetails) {
                user = (User) auth.getPrincipal();
            }
        }
        return ResponseEntity.ok(collectionDtoService.findCollectionByType(type, user));
    }

    @PostMapping
    public ResponseEntity<Void> postCollectionResponseDto(@RequestBody CollectionRequestDto collectionRequestDto) {
        Collection collections = new Collection(collectionRequestDto.getName(), collectionRequestDto.getType());
        collectionDtoService.create(collections);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCollectionResponseDto(@PathVariable Long id, @RequestBody CollectionRequestDto collectionRequestDto) {
        Collection updateCollections = collectionDtoService.getById(id).orElse(null);
        if (updateCollections == null) {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
        updateCollections.setName(collectionRequestDto.getName());
        updateCollections.setCollectionType(collectionRequestDto.getType());
        collectionDtoService.update(updateCollections);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        Collection collectionsDeactivate = collectionDtoService.getById(id).orElse(null);
        if (collectionsDeactivate == null) {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
        collectionsDeactivate.setEnable(false);
        collectionDtoService.update(collectionsDeactivate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long id) {
        Collection collectionsActive = collectionDtoService.getById(id).orElse(null);
        if (collectionsActive == null) {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
        collectionsActive.setEnable(true);
        collectionDtoService.update(collectionsActive);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollections(@PathVariable Long id) {
        if (collectionDtoService.isExistById(id)) {
            collectionDtoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
    }

    @PostMapping("/{id}/movies")
    public ResponseEntity<Void> addMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {
        Collection collectionsAddMovie = collectionDtoService.getById(id).orElse(null);
        Set<Long> setMoviesId = new HashSet<>(movieIds);
        if (collectionsAddMovie != null) {
            Set<Movie> moviesSet = collectionsAddMovie.getMovies();
            if (moviesSet.isEmpty()) {
                for (Long i : setMoviesId) {
                    moviesSet.add(movieDtoService.getById(i).get());
                }
            } else {
                Set<Long> availableFilmsId = new HashSet<>();
                for (Movie i : moviesSet) {
                    availableFilmsId.add(i.getId());
                }
                availableFilmsId.addAll(setMoviesId);
                for (Long i : availableFilmsId) {
                    moviesSet.add(movieDtoService.getById(i).get());
                }
            }
            collectionDtoService.update(collectionsAddMovie);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
    }

    @DeleteMapping("/{id}/movies")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {

        Collection collectionsDeleteMovie = collectionDtoService.getById(id).orElse(null);
        Set<Long> setMoviesDeleteId = new HashSet<>(movieIds);
        if (collectionsDeleteMovie != null) {
            Set<Movie> moviesSet = collectionsDeleteMovie.getMovies();
            Set<Movie> deleteSet = new HashSet<>();
            if (!moviesSet.isEmpty()) {
                for (Movie i : moviesSet) {
                    for (Long n : setMoviesDeleteId) {
                        if (i.getId().equals(n)) {
                            deleteSet.add(movieDtoService.getById(n).get());
                        }
                    }
                }
                moviesSet.removeAll(deleteSet);
            } else {
                throw new NotFoundByIdException("There is no movie with ID: " + id + " , try again.");
            }

            collectionDtoService.update(collectionsDeleteMovie);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<PageDto<CollectionMoviesResponseDto>> getCollectionMovies(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false, defaultValue = "false") Boolean online,
            @RequestParam(required = false, defaultValue = "ORDER") СollectionSortType collectionSortType, @PathVariable Long id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("country", country);
        parameters.put("genre", genre);
        parameters.put("date", date);
        parameters.put("online", online);
        parameters.put("collectionSortType", collectionSortType);
        return ResponseEntity.ok(collectionMoviesResponseDtoService.getPageDtoWithParameters(id, parameters, date));
    }
}
