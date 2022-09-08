package com.kata.cinema.base.webapp.controllers.unauthorized;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import com.kata.cinema.base.models.dto.request.CollectionRequestDto;
import com.kata.cinema.base.models.dto.response.CollectionResponseDto;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.entitys.Movie;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.models.enums.CollectionType;
import com.kata.cinema.base.service.entity.CollectionService;
import com.kata.cinema.base.service.entity.FolderMoviesService;
import com.kata.cinema.base.service.entity.MovieService;
import com.kata.cinema.base.service.entity.UserService;
import lombok.AllArgsConstructor;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/collections")
@AllArgsConstructor
public class CollectionRestController {

    private final CollectionService collectionService;
    private final FolderMoviesService folderMoviesService;
    private final MovieService movieService;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<CollectionResponseDto>> getCollectionResponseDto(@RequestParam(defaultValue = "MOVIES") CollectionType type) {

        //TODO доработать логику, доставать сразу dto
//        FolderMovies folderMovies =  folderMoviesService.findByUserId(user_id);
//           Integer countViewedMovies = folderMovies.getMovies().size();
//        List<Collection> collections = collectionService.findCollectionByType(type);
//        List<CollectionResponseDto> collectionsDtos = new ArrayList<>();
//        for (Collection c : collections) {
//            CollectionResponseDto collectionResponseDto = new CollectionResponseDto(c.getId(), c.getName(), c.getCollectionUrl(), 0, 0);
//            collectionsDtos.add(collectionResponseDto);
//        }
//        return ResponseEntity.ok(collectionsDtos);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (auth != null) {
            if (auth.getPrincipal() instanceof UserDetails) {
                // user =  userService.findByEmail(((UserDetails) auth.getPrincipal()).getUsername());
                user = (User) auth.getPrincipal();
            }
        }
        return ResponseEntity.ok(collectionService.findCollectionByType(type, user));
    }

    @PostMapping
    public ResponseEntity<Void> postCollectionResponseDto(CollectionRequestDto collectionRequestDto) {
        Collection collections = new Collection(collectionRequestDto.getName(), collectionRequestDto.getType());
        collectionService.create(collections);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCollectionResponseDto(@PathVariable Long id, CollectionRequestDto collectionRequestDto) {
        Collection updateCollections = collectionService.getById(id).orElse(null);
        if (updateCollections == null) {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
        updateCollections.setName(collectionRequestDto.getName());
        updateCollections.setCollectionType(collectionRequestDto.getType());
        collectionService.update(updateCollections);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        Collection collectionsDeactivate = collectionService.getById(id).orElse(null);
        if (collectionsDeactivate == null) {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
        collectionsDeactivate.setEnable(false);
        collectionService.update(collectionsDeactivate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Void> activate(@PathVariable Long id) {
        Collection collectionsActive = collectionService.getById(id).orElse(null);
        if (collectionsActive == null) {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
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
        throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
    }

    @PostMapping("/{id}/movies")
    public ResponseEntity<Void> addMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {
        Collection collectionsAddMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesId = new HashSet<>(movieIds);
        if (collectionsAddMovie != null) {
            Set<Movie> moviesSet = collectionsAddMovie.getMovies();
            if (moviesSet.isEmpty()) {
                for (Long i : setMoviesId) {
                    moviesSet.add(movieService.getById(i));
                }
            } else {
                Set<Long> availableFilmsId = new HashSet<>();
                for (Movie i : moviesSet) {
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
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
    }

    @DeleteMapping("/{id}/movies")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id,@RequestBody List<Long> movieIds) {

        Collection collectionsDeleteMovie = collectionService.getById(id).orElse(null);
        Set<Long> setMoviesDeleteId = new HashSet<>(movieIds);
        if (collectionsDeleteMovie != null) {
            Set<Movie> moviesSet = collectionsDeleteMovie.getMovies();
            Set<Movie> deleteSet = new HashSet<>();
            if (!moviesSet.isEmpty()) {
                for (Movie i : moviesSet) {
                    for (Long n : setMoviesDeleteId) {
                        if (i.getId().equals(n)) {
                            deleteSet.add(movieService.getById(n));
                        }
                    }
                }
                moviesSet.removeAll(deleteSet);
            } else {
                throw new NotFoundByIdException("There is no movie with ID: " + id + " , try again.");
            }

            collectionService.update(collectionsDeleteMovie);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundByIdException("There is no collection with ID: " + id + " , try again.");
        }
    }
}
