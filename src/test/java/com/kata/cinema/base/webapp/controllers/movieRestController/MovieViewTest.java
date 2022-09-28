package com.kata.cinema.base.webapp.controllers.movieRestController;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/movieRestController/MovieViewInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/movieRestController/MovieViewClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class MovieViewTest extends AbstractTest {

    @Test
    public void getMovieView() throws Exception {
        mockMvc.perform(get("/api/movies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(14)))
                .andExpect(jsonPath("$.casts.length()", Is.is(1)))
                .andExpect(jsonPath("$.casts[0].persons.length()", Is.is(1)))
                .andExpect(jsonPath("$.countScore").value(5))
                .andExpect(jsonPath("$.score").value(7))
                .andExpect(jsonPath("$.countScore").value(5))
                .andExpect(jsonPath("$.previewUrl").value("url1"))
                .andExpect(jsonPath("$.genres").value("genre1 | genre2 | genre3"))
                .andExpect(jsonPath("$.mpaa").value("GENERAL_AUDIENCES"))
                .andExpect(jsonPath("$.countries").value("country1"))
                .andExpect(jsonPath("$.casts[0].professionId").value("1"))
                .andExpect(jsonPath("$.casts[0].movieId").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.casts[0].professionName").value("name1"))
                .andExpect(jsonPath("$.casts[0].persons[0].professionId").doesNotHaveJsonPath())
                .andExpect(jsonPath("$.casts[0].persons[0].personId").value(1))
                .andExpect(jsonPath("$.casts[0].persons[0].originalFullName").value("origlast1 origname1"))
                .andExpect(jsonPath("$.myScore").doesNotExist());
    }

    @Test
    public void getMovieViewWithWrongId() throws Exception {
        mockMvc.perform(get("/api/movies/10"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.text").value("Не существует такое кино"));
    }
}
