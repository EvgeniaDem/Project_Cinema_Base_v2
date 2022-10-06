package com.kata.cinema.base.webapp.controllers.reviewRestController;

import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import com.kata.cinema.base.AbstractTest;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/reviewRestController/ReviewInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/reviewRestController/ReviewClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ReviewRestControllerTest extends AbstractTest {
    private static String accessToken;

    @Test
    public void getRatingForReview() throws Exception {
        accessToken = obtainNewAccessToken("user2@mail.ru", "102", mockMvc);
        mockMvc.perform(post("/api/user/reviews/1?typeRating=LIKE")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());
    }
}