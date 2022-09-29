package com.kata.cinema.base.webapp.initializer;

import com.kata.cinema.base.models.entitys.*;
import com.kata.cinema.base.models.entitys.Collection;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;

import com.kata.cinema.base.service.dto.CollectionDtoService;
import com.kata.cinema.base.service.dto.GenreDtoService;
import com.kata.cinema.base.service.dto.MovieDtoService;
import com.kata.cinema.base.service.dto.PersonsDtoService;
import com.kata.cinema.base.service.entity.MoviePersonService;
import com.kata.cinema.base.service.entity.PersonMarriageService;
import com.kata.cinema.base.service.entity.ProfessionService;
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

import static com.kata.cinema.base.models.enums.TypeCharacter.*;

/*
 * In order to initialize some data for Movie, Genre, Collection entity-related tables
 * */
@Component
@ConditionalOnExpression("${RUN_INIT:true}")
public class TestDataInitializer {

    private final MovieDtoService movieDtoService;
    private final GenreDtoService genreDtoService;
    private final CollectionDtoService collectionDtoService;
    private final PersonsDtoService personsDtoService;
    private final ProfessionService professionService;
    private final MoviePersonService moviePersonService;
    private final PersonMarriageService personMarriageService;

    public TestDataInitializer(MovieDtoService movieDtoService, GenreDtoService genreDtoService, CollectionDtoService collectionDtoService, PersonsDtoService personsDtoService, ProfessionService professionService, MoviePersonService moviePersonService, PersonMarriageService personMarriageService) {
        this.movieDtoService = movieDtoService;
        this.genreDtoService = genreDtoService;
        this.collectionDtoService = collectionDtoService;
        this.personsDtoService = personsDtoService;
        this.professionService = professionService;
        this.moviePersonService = moviePersonService;
        this.personMarriageService = personMarriageService;
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

    @EventListener(ApplicationReadyEvent.class)
    @Order(4)
    public void personInit() {
        for (int i = 1; i <= 50; i++) {
            Person person = new Person();
            person.setFirstName("Имя " + i);
            person.setLastName("Фамилия " + i);
            person.setOriginalName("Name " + i);
            person.setOriginalLastName("LastName " + i);

            double x = ThreadLocalRandom.current().nextDouble(1.50, 2.20);
            person.setHeight(Math.round(x * 100.0) / 100.0);

            person.setBirthday(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(LocalDate.of(1970, Month.JANUARY, 1)
                            .toEpochDay(),
                    LocalDate.now().toEpochDay())));

            person.setPhotoUrl("/uploads/persons/photos/" + i + "persons");
            person.setPlaceBirthday("Место рождения " + i);

            personsDtoService.create(person);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(5)
    public void professionInit() {
        String[] professions = {"Режиссер", "Сценарист", "Продюсер", "Оператор", "Композитор", "Художник", "Монтажер", "Костюмер", "Гримёр", "Актер"};
        for (int i = 0; i < 10; i++) {
            Profession profession = new Profession();
            profession.setName(professions[i]);
            professionService.create(profession);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(6)
    public void moviePersonInit() {
        List<Movie> movieList = new ArrayList<>(movieDtoService.getAll());
        for (Movie movie : movieList) {
            MoviePerson moviePerson = new MoviePerson();
            MoviePerson.Id id = new MoviePerson.Id();
            moviePerson.setMovie(movie);
            List<Person> personList = new ArrayList<>(personsDtoService.getAll());
            Collections.shuffle(personList);

            for (int j = 0; j < 10; j++) {
                moviePerson.setPerson(personList.get(j));
                List<Profession> professionList = new ArrayList<>(professionService.getAll());
                if (j < 6) {
                    moviePerson.setProfessions(professionService.getByName("Актер"));
                    if (j < 3) {
                        moviePerson.setType(MAIN_CHARACTER);
                    } else {
                        moviePerson.setType(MINOR_CHARACTER);
                    }
                    id.setProfessionId(professionService.getByName("Актер").getId());
                } else {
                    long index = ThreadLocalRandom.current().nextInt(0, professionList.size() - 1);
                    moviePerson.setProfessions(professionList.get((int) index));
                    moviePerson.setType(NO_CHARACTER_MOVIE);
                    id.setProfessionId(professionList.get((int) index).getId());
                }
                id.setMovieId(movie.getId());
                id.setPersonId(personList.get(j).getId());
                moviePerson.setId(id);
                moviePersonService.create(moviePerson);
            }
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(7)
    public void personMarriageInit() {
        for (int i = 1; i <= 50; i = i + 2) {
            PersonMarriage personMarriage = new PersonMarriage();
            personMarriage.setPerson(personsDtoService.getById((long) i).orElse(null));
            personMarriage.setHuman(personsDtoService.getById((long) i + 1).orElse(null));
            String[] marriageStatus = {"married", "divorced", "not married"};
            int index = ThreadLocalRandom.current().nextInt(0, marriageStatus.length);
            personMarriage.setMarriageStatus(marriageStatus[index]);
            personMarriageService.create(personMarriage);
        }
    }
}
