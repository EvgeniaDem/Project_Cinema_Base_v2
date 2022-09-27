package com.kata.cinema.base.webapp.initializer;

import com.kata.cinema.base.models.entitys.*;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;

import com.kata.cinema.base.service.entity.*;
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

    private final MovieService movieService;
    private final GenreService genreService;
    private final CollectionService collectionService;

    public TestDataInitializer(MovieService movieService, GenreService genreService, CollectionService collectionService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.collectionService = collectionService;
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

            List<Genre> genreList = new ArrayList<>(genreService.getAll());
            int randomSize = ThreadLocalRandom.current().nextInt(1, 4);
            Collections.shuffle(genreList);
            movie.setGenres(new HashSet<>(genreList.subList(genreList.size() - randomSize, genreList.size())));

            movieService.create(movie);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(1)
    public void genreInit() {
        for (int i = 1; i <= 10; i++) {
            genreService.create(new Genre("Жанр" + i));
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(3)
    public void collectionInit() {
        for (int i = 1; i <= 20; i++) {
            boolean enable = !Arrays.asList(2, 6, 10, 14, 18).contains(i);
            Collection collection = new Collection("Коллекция" + i, enable);

            List<Movie> movieList = new ArrayList<>(movieService.getAll());
            int randomSize = ThreadLocalRandom.current().nextInt(5, 16);
            Collections.shuffle(movieList);
            collection.setMovies(new HashSet<>(movieList.subList(movieList.size() - randomSize, movieList.size())));

            collectionService.create(collection);
        }
    }
}
