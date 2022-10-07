package com.kata.cinema.base.webapp.controllers.reviewRestController;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import com.kata.cinema.base.AbstractTest;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Sql(value = "/data/sql/controller/reviewRestController/ReviewInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/reviewRestController/ReviewClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ReviewRestControllerTest extends AbstractTest {
    private static String accessToken;

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
                .andExpect(jsonPath("$.entities[0].date", Is.is("09.08.2022")));

    }

    @Test
    public void getEmptyValuesWithWrongId() throws Exception {
        mockMvc.perform(get("/api/movies/{id}/reviews/page/{pageNumber}", 200, 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", Is.is(0)));
    }

    @Test
    public void getRatingForReview() throws Exception {
        accessToken = obtainNewAccessToken("user2@mail.ru", "102", mockMvc);
        mockMvc.perform(post("/api/user/reviews/1?typeRating=LIKE")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());
    }
}