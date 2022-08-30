package com.kata.cinema.base.webapp.controllers.unauthorized.movieRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static com.kata.cinema.base.AbstractIT.MOVIE_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.MOVIE_REST_CONTROLLER_INIT_SQL;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = MOVIE_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = MOVIE_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//TODO переделать, как остальные тесты
@Ignore
public class GetIT extends AbstractIT {
    private final String URL = "/api/movies";

    public GetIT() {
    }

    @Test
    @Disabled
    public void getReleaseFilms() throws Exception {
        this.mockMvc.perform(get(URL + "/release"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].name").value("release"));
    }

    @Test
    @Disabled
    public void getTopMovies() throws Exception {
        this.mockMvc.perform(get(URL + "/top?pageNumber=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(5)));
    }

    @Test
    @Disabled
    public void getTopMoviesWithDateParams() throws Exception {
        this.mockMvc.perform(get(URL + "/top?pageNumber=1&startDate=2022-08-14&endDate=2022-08-14"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(1)))
                .andExpect(jsonPath("$.entities.[0].name").value("1"));
    }

    @Test
    @Disabled
    public void getTopMoviesWithTypeSortParam() throws Exception {
        this.mockMvc.perform(get(URL + "/top?pageNumber=1&TopMoviesType=DATE_RELEASE"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(5)))
                .andExpect(jsonPath("$.entities.[0].name").value("1"));
    }
}