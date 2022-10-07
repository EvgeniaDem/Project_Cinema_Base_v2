package com.kata.cinema.base.webapp.controllers.movieRestController;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Sql(value = "/data/sql/controller/movieRestController/MovieInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/movieRestController/MovieClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Ignore
public class MovieNewsPageTest extends AbstractTest {
    @Test
    @Disabled
    public void getPageWithoutParameters() throws Exception {
        mockMvc.perform(get("/api/movies/2/materials"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.length()", Is.is(3)))
                .andExpect(jsonPath("$.entities[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.count").value(3))
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.entities[0].description").value("2 test"))
                .andExpect(jsonPath("$.entities[1].description").value("2 test"))
                .andExpect(jsonPath("$.entities[0].id").value(100))
                .andExpect(jsonPath("$.entities[1].id").value(200))
                .andExpect(jsonPath("$.entities[1].countComment").value(2));
    }

    @Test
    @Disabled
    public void getPageWithParameters() throws Exception {
        mockMvc.perform(get("/api/movies/2/materials?count=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.length()", Is.is(1)))
                .andExpect(jsonPath("$.entities[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.count").value(3))
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.entities[0].description").value("2 test"))
                .andExpect(jsonPath("$.entities[0].id").value(200))
                .andExpect(jsonPath("$.entities[0].countComment").value(2));
    }
}
