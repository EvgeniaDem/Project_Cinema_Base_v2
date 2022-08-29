package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.exceptions.IdNotFoundException;
import com.kata.cinema.base.models.dto.CollectionRequestDto;
import com.kata.cinema.base.models.dto.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.entitys.FolderMovies;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.abstracts.model.CollectionService;
import com.kata.cinema.base.service.abstracts.model.FolderMoviesService;
import com.kata.cinema.base.service.abstracts.model.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/collections")
public class CollectionRestController {

    private CollectionService collectionService;
    private FolderMoviesService folderMoviesService;
    private MovieService movieService;


    public CollectionRestController(CollectionService collectionService, FolderMoviesService folderMoviesService, MovieService movieService) {
        this.collectionService = collectionService;
        this.folderMoviesService = folderMoviesService;
        this.movieService = movieService;
    }


    @GetMapping
    public ResponseEntity<List<CollectionResponseDto>> getCollectionResponseDto(@RequestParam(defaultValue = "MOVIES") CollectionType type) {

        //TODO доработать логику, доставать сразу dto
       // FolderMovies folderMovies =  folderMoviesService.findByUserId(user_id);
        //   Integer countViewedMovies = folderMovies.getMovies().size();

        List<Collections> collections = collectionService.findCollectionByType(type);
        List<CollectionResponseDto> collectionsDtos = new ArrayList<>();
        for (Collections c : collections) {
            CollectionResponseDto collectionResponseDto = new CollectionResponseDto(c.getId(), c.getName(), c.getCollectionUrl(), 0, 0);
            collectionsDtos.add(collectionResponseDto);
        }

        return ResponseEntity.ok(collectionsDtos);
    }



    @PostMapping
    public ResponseEntity<Void> postCollectionResponseDto(CollectionRequestDto collectionRequestDto) {
        Collections collections = new Collections(collectionRequestDto.getName(), collectionRequestDto.getType());
        collectionService.create(collections);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCollectionResponseDto(@PathVariable Long id, CollectionRequestDto collectionRequestDto) {
        Collections updateCollections = collectionService.getById(id).orElse(null);
        if (updateCollections == null) {
            throw new IdNotFoundException("There is no collection with ID: " + id + " , try again.");
        }
        updateCollections.setName(collectionRequestDto.getName());
        updateCollections.setCollectionType(collectionRequestDto.getType());
        collectionService.update(updateCollections);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        Collections collectionsDeactivate = collectionService.getById(id).orElse(null);
        if (collectionsDeactivate == null) {
            throw new IdNotFoundException("There is no collection with ID: " + id + " , try again.");
        }
        collectionsDeactivate.setEnable(false);
        collectionService.update(collectionsDeactivate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long id) {
        Collections collectionsActive = collectionService.getById(id).orElse(null);
        if (collectionsActive == null) {
            throw new IdNotFoundException("There is no collection with ID: " + id + " , try again.");
        }
        collectionsActive.setEnable(true);
        collectionService.update(collectionsActive);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollections(@PathVariable Long id) {
        if (collectionService.isExistById(id)) {
            collectionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new IdNotFoundException("There is no collection with ID: " + id + " , try again.");
    }

    @PostMapping("/{id}/movies")
    public ResponseEntity<Void> addMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {
        Collections collectionsAddMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesId = new HashSet<>(movieIds);
        if (collectionsAddMovie != null) {
            Set<Movies> moviesSet = collectionsAddMovie.getMovies();
            if (moviesSet.isEmpty()) {
                for (Long i : setMoviesId) {
                    moviesSet.add(movieService.getById(i));
                }
            } else {
                Set<Long> availableFilmsId = new HashSet<>();
                for (Movies i : moviesSet) {
                    availableFilmsId.add(i.getId());
                }
                availableFilmsId.addAll(setMoviesId);
                for (Long i : availableFilmsId) {
                    moviesSet.add(movieService.getById(i));
                }
            }
            collectionService.update(collectionsAddMovie);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new IdNotFoundException("There is no collection with ID: " + id + " , try again.");
        }
    }

    @DeleteMapping("/{id}/movies")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {

        Collections collectionsDeleteMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesDeleteId = new HashSet<>(movieIds);
        if (collectionsDeleteMovie != null) {
            Set<Movies> moviesSet = collectionsDeleteMovie.getMovies();
            Set<Movies> deleteSet = new HashSet<>();
            if (!moviesSet.isEmpty()) {
                for (Movies i : moviesSet) {
                    for (Long n : setMoviesDeleteId) {
                        if (i.getId() == n) {
                            deleteSet.add(movieService.getById(n));
                        }
                    }
                }
                moviesSet.removeAll(deleteSet);
            } else {
                throw new IdNotFoundException("There is no movie with ID: " + id + " , try again.");
            }

            collectionService.update(collectionsDeleteMovie);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new IdNotFoundException("There is no collection with ID: " + id + " , try again.");
        }

    }


}
