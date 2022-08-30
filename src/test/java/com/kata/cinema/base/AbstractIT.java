package com.kata.cinema.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ActiveProfiles("IT")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners({
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class,
        SqlScriptsTestExecutionListener.class
})
@Disabled
public class AbstractIT {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @PersistenceContext
    protected EntityManager entityManager;

    public static final String SEARCH_REST_CONTROLLER_MOVIE_INIT_SQL = "classpath:data/sql/controller/searchRestController/SearchMovieInit.sql";
    public static final String SEARCH_REST_CONTROLLER_MOVIE_CLEAR_SQL = "classpath:data/sql/controller/searchRestController/SearchMovieClear.sql";
    public static final String MOVIE_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/movieRestController/MovieInit.sql";
    public static final String MOVIE_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/movieRestController/MovieClear.sql";
}

