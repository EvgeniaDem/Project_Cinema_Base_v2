package com.kata.cinema.base.webapp.controllers.movieRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/movieRestController/ExcertionForMovieInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/movieRestController/ExcertionForMovieClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetExcertionsForMovieTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void getFirstPageWithExcertionsForMovie() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/1/excertions/page/1?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(5)))
                .andExpect(jsonPath("$.entities.[0].id").value(203))
                .andExpect(jsonPath("$.entities.[0].description").value("Test1"))
                .andExpect(jsonPath("$.entities.[0].id").value(217))
                .andExpect(jsonPath("$.entities.[0].description").value("Test9"))
                .andExpect(jsonPath("$.entities.[0].id").value(218))
                .andExpect(jsonPath("$.entities.[0].description").value("Test11"))
                .andExpect(jsonPath("$.entities.[0].id").value(219))
                .andExpect(jsonPath("$.entities.[0].description").value("Test13"))
                .andExpect(jsonPath("$.entities.[0].id").value(220))
                .andExpect(jsonPath("$.entities.[0].description").value("Test15"));
    }

    @Test
    public void getLastPageWithExcertionsForMovie() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/1/excertions/page/2?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(2)))
                .andExpect(jsonPath("$.entities.[0].id").value(221))
                .andExpect(jsonPath("$.entities.[0].description").value("Test17"))
                .andExpect(jsonPath("$.entities.[0].id").value(222))
                .andExpect(jsonPath("$.entities.[0].description").value("Test19"));
    }

    @Test
    public void getFirstPageWithExcertionsForOtherMovie() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/2/excertions/page/1?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(1)))
                .andExpect(jsonPath("$.entities.[0].id").value(214))
                .andExpect(jsonPath("$.entities.[0].description").value("Test3"));
    }
}