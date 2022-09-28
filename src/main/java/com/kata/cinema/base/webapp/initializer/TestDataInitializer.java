package com.kata.cinema.base.webapp.initializer;

import com.kata.cinema.base.models.entitys.*;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;

import com.kata.cinema.base.service.dto.CollectionDtoService;
import com.kata.cinema.base.service.dto.GenreDtoService;
import com.kata.cinema.base.service.dto.MovieDtoService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/*
* In order to initialize some data for entity-related tables
* */
@Component
@ConditionalOnExpression("${RUN_INIT:false}")
public class TestDataInitializer {

    private final MovieDtoService movieDtoService;
    private final GenreDtoService genreDtoService;
    private final CollectionDtoService collectionDtoService;

    public TestDataInitializer(MovieDtoService movieDtoService, GenreDtoService genreDtoService, CollectionDtoService collectionDtoService) {
        this.movieDtoService = movieDtoService;
        this.genreDtoService = genreDtoService;
        this.collectionDtoService = collectionDtoService;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(2)
    public void movieInit() {
        for (int i = 1; i <= 100; i++) {
            Movie movie = new Movie();
            movie.setName("фильм" + i);
            movie.setDateRelease(LocalDate.ofEpochDay(ThreadLocalRandom.current()
                    .nextLong(LocalDate.of(1990, Month.JANUARY, 1).toEpochDay(),
                            LocalDate.now().toEpochDay())));
            movie.setTime(ThreadLocalRandom.current().nextInt(100, 181));
            movie.setDescription("описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма\n" +
                            "описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма\n" +
                            "описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма\n" +
                            "описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма");

            List<MPAA> mpaaList = Arrays.asList(MPAA.values());
            movie.setMpaa(mpaaList.get(new SecureRandom().nextInt(mpaaList.size())));

            List<RARS> rarsList = Arrays.asList(RARS.values());
            movie.setRars(rarsList.get(new SecureRandom().nextInt(rarsList.size())));

            List<Genre> genreList = new ArrayList<>(genreDtoService.getAll());
            int randomSize = ThreadLocalRandom.current().nextInt(1, 4);
            Collections.shuffle(genreList);
            movie.setGenres(new HashSet<>(genreList.subList(genreList.size() - randomSize, genreList.size())));

            movieDtoService.create(movie);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(1)
    public void genreInit() {
        for (int i = 1; i <= 10; i++) {
            genreDtoService.create(new Genre("Жанр" + i));
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(3)
    public void collectionInit() {
        for (int i = 1; i <= 20; i++) {
            boolean enable = !Arrays.asList(2, 6, 10, 14, 18).contains(i);
            Collection collection = new Collection("Коллекция" + i, enable);

            List<Movie> movieList = new ArrayList<>(movieDtoService.getAll());
            int randomSize = ThreadLocalRandom.current().nextInt(5, 16);
            Collections.shuffle(movieList);
            collection.setMovies(new HashSet<>(movieList.subList(movieList.size() - randomSize, movieList.size())));

            collectionDtoService.create(collection);
        }
    }
}
