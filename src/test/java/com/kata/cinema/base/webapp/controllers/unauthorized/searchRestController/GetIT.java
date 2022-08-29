package com.kata.cinema.base.webapp.controllers.unauthorized.searchRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = SEARCH_REST_CONTROLLER_MOVIE_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = SEARCH_REST_CONTROLLER_MOVIE_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetIT extends AbstractIT {

    private final String URL = "/api/search";

    @Test
    public void getMoviesPage() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?name=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(2)))
                .andExpect(jsonPath("$.count", equalTo(2)));
    }


    @Test
    public void getMoviesWithAllParams() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?itemsOnPage=3&name=3&startDate=2020-08-08&endDate=2023-08-08" +
                        "&genres=genre 3&rars=2&mpaa=1&sortType=NAME_DESC"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(1)))
                .andExpect(jsonPath("$.count", equalTo(1)))
                .andExpect(jsonPath("$.entities.[0].name").value("3331"));
    }

    @Test
    public void getMoviesWithNameParam() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?name=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(1)))
                .andExpect(jsonPath("$.count", equalTo(1)))
                .andExpect(jsonPath("$.entities.[0].name").value("5555"));
    }

    @Test
    public void getMoviesWithDateParams() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?name=1&startDate=2022-08-14&endDate=2022-08-15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(2)))
                .andExpect(jsonPath("$.count", equalTo(2)))
                .andExpect(jsonPath("$.entities.[0].name").value("1111"))
                .andExpect(jsonPath("$.entities.[1].name").value("1222"));
        this.mockMvc.perform(get(URL + "/movies/page/1?name=1&endDate=2022-08-15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(2)))
                .andExpect(jsonPath("$.count", equalTo(2)))
                .andExpect(jsonPath("$.entities.[0].name").value("1111"))
                .andExpect(jsonPath("$.entities.[1].name").value("1222"));
        this.mockMvc.perform(get(URL + "/movies/page/1?name=3&startDate=2022-08-16"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(1)))
                .andExpect(jsonPath("$.count", equalTo(1)))
                .andExpect(jsonPath("$.entities.[0].name").value("3331"));
    }

    @Test
    public void getMoviesWithGenresParam() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?name=1&genres=genre 1&genres=genre 2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(2)))
                .andExpect(jsonPath("$.count", equalTo(2)))
                .andExpect(jsonPath("$.entities.[0].name").value("1111"))
                .andExpect(jsonPath("$.entities.[1].name").value("1222"));
    }

    @Test
    public void getMoviesWithScoreParam() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?name=55&rars=3&mpaa=4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(1)))
                .andExpect(jsonPath("$.count", equalTo(1)))
                .andExpect(jsonPath("$.entities.[0].name").value("5555"));
    }

    @Test
    public void getMoviesWithSortTypeParam() throws Exception {
        this.mockMvc.perform(get(URL + "/movies/page/1?name=1&sortType=DATE_RELEASE_DESC"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.*", hasSize(2)))
                .andExpect(jsonPath("$.count", equalTo(2)))
                .andExpect(jsonPath("$.entities.[0].name").value("1222"))
                .andExpect(jsonPath("$.entities.[1].name").value("1111"));
    }


}