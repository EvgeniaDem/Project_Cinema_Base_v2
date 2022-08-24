package com.kata.cinema.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("IT")
public abstract class AbstractIT {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    public static final String PUBLICIST_NEWS_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/publicistNewsRestController/NewsInit.sql";
    public static final String PUBLICIST_NEWS_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/publicistNewsRestController/NewsClear.sql";
    public static final String NEWS_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/newsRestController/NewsInit.sql";
    public static final String NEWS_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/newsRestController/NewsClear.sql";
    public static final String USER_NEWS_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/userNewsRestController/userNewsInit.sql";
    public static final String USER_NEWS_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/userNewsRestController/userNewsClear.sql";
    public static final String SEARCH_REST_CONTROLLER_MOVIE_INIT_SQL = "classpath:data/sql/controller/searchRestController/SearchMovieInit.sql";
    public static final String SEARCH_REST_CONTROLLER_MOVIE_CLEAR_SQL = "classpath:data/sql/controller/searchRestController/SearchMovieClear.sql";
    public static final String MOVIE_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/movieRestController/MovieInit.sql";
    public static final String MOVIE_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/movieRestController/MovieClear.sql";
    public static final String GENRES_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/adminGenresRestController/GenresInit.sql";
    public static final String GENRES_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/adminGenresRestController/GenresClear.sql";

}

