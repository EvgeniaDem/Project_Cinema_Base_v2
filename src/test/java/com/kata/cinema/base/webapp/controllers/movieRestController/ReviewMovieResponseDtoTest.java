package com.kata.cinema.base.webapp.controllers.movieRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql(value = "/data/sql/controller/movieRestController/ReviewInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/movieRestController/ReviewClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class ReviewMovieResponseDtoTest extends AbstractTest {

    @Test
    public void getReviewMovieResponseDto() throws Exception {
        mockMvc.perform(get("/api/movies/1/reviews/page/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
