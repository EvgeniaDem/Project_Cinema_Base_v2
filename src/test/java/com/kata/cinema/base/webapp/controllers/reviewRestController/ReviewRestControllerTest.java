package com.kata.cinema.base.webapp.controllers.reviewRestController;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import com.kata.cinema.base.AbstractTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql(value = "/data/sql/controller/reviewRestController/ReviewInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/reviewRestController/ReviewClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ReviewRestControllerTest extends AbstractTest {

    @Test
    public void getReviews() throws Exception {
        mockMvc.perform(get("/api/movies/{id}/reviews/page/{pageNumber}", 100, 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", Is.is(1)))
                .andExpect(jsonPath("$.entities[0].id", Is.is(100)))
                .andExpect(jsonPath("$.entities[0].typeReview", Is.is("NEGATIVE")))
                .andExpect(jsonPath("$.entities[0].title", Is.is("title1")))
                .andExpect(jsonPath("$.entities[0].description", Is.is("description123")))
                .andExpect(jsonPath("$.entities[0].fullName", Is.is("test_firstname test_lastname")))
                .andExpect(jsonPath("$.entities[0].date[0]", Is.is(2022)))
                .andExpect(jsonPath("$.entities[0].date[1]", Is.is(8)))
                .andExpect(jsonPath("$.entities[0].date[2]", Is.is(9)));
    }

    @Test
    public void getEmptyValuesWithWrongId() throws Exception {
        mockMvc.perform(get("/api/movies/{id}/reviews/page/{pageNumber}", 200, 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", Is.is(0)));
    }

    @Test
    public void getEmptyValuesWithWrongPage() throws Exception {
        mockMvc.perform(get("/api/movies/{id}/reviews/page/{pageNumber}", 100, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.length()", Is.is(0)));
    }
}