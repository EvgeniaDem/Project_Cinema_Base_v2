package com.kata.cinema.base.webapp.controllers.user.userCommentRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.enums.TypeRating;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserCommentRestControllerTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void addReaction() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "user", mockMvc);
        mockMvc.perform(patch("/api/user/comment/{id}?typeRating={reaction}", 200L, TypeRating.like)
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateReaction() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "user", mockMvc);
        mockMvc.perform(patch("/api/user/comment/{id}?typeRating={reaction}", 300L, TypeRating.like)
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                ).andDo(print())
                .andExpect(status().isOk());
    }
}