package com.kata.cinema.base.webapp.initializer;

import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import liquibase.repackaged.org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
* In order to initialize some data for Movie, Genre, Collection entity-related tables
* */
@Component
@ConditionalOnExpression("${RUN_INIT:true}") //edition parameter at the application.properties
public class MovieGenreCollectionInit {

    @EventListener(ApplicationReadyEvent.class)
    @Order(1)
    public void movieInit() {
        for (int i = 1; i <= 100; i++) {
            StringBuilder film = new StringBuilder("фильм").append(i);
            LocalDate dateOfRelease = LocalDate.ofEpochDay(ThreadLocalRandom.current()
                    .nextLong(LocalDate.of(1990, Month.JANUARY, 1).toEpochDay(),
                            LocalDate.now().toEpochDay()));
            int time = ThreadLocalRandom.current().nextInt(100, 180);
            String description = "описание описание описание описание описание описание описание описание описание описание описание описание";
            List<MPAA> mpaaList= Arrays.asList(MPAA.values());
            MPAA mpaa = mpaaList.get(new SecureRandom().nextInt(mpaaList.size()));
            List<RARS> rarsList= Arrays.asList(RARS.values());
            RARS rars = rarsList.get(new SecureRandom().nextInt(rarsList.size()));
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(2)
    public void genreInit() {
        for (int i = 1; i <= 10; i++) {
            StringBuilder name = new StringBuilder("жанр").append(i);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(3)
    public void collectionInit() {
        for (int i = 1; i <= 20; i++) {
            StringBuilder collection = new StringBuilder("коллекция").append(i);
            boolean enable;
            switch (i) {
                case 2,6,10,14,18 -> enable = false;
                default -> enable = true;
            }

        }
    }
}
