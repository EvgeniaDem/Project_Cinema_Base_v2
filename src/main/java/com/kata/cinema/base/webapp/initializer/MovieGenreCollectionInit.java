package com.kata.cinema.base.webapp.initializer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
* In order to initialize some data for Movie, Genre, Collection entity-related tables
* */
@Component
@ConditionalOnExpression("${RUN_INIT:true}") //edition parameter at the application.properties
public class MovieGenreCollectionInit {

    @EventListener(ApplicationReadyEvent.class)
    @Order(1)
    public void movieInit() {

    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(2)
    public void genreInit() {

    }

    @EventListener(ApplicationReadyEvent.class)
    @Order(3)
    public void collectionInit() {

    }
}
