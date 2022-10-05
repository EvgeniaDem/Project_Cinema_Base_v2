package com.kata.cinema.base.webapp.controllers.user.userNewsRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UserNewsRestControllerTest extends AbstractTest {


    private static String accessToken;

    @Test
    public void deleteComment() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "user", mockMvc);
        mockMvc.perform(delete("/api/user/news/{id}/comments", 300L)
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                ).andDo(print())
                .andExpect(status().isOk());

        Assert.assertTrue(entityManager.createQuery("SELECT count(c) < 1 FROM Comment c WHERE c.id = :id", Boolean.class)
                .setParameter("id", 300L).getSingleResult());
    }

    @Test
    public void updateComment() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "user", mockMvc);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("refactoring collection", 0L, 0);
        this.mockMvc.perform(put("/api/user/news/{id}/comments", 100)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto))
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());
        Assert.assertTrue(entityManager.createQuery("SELECT count(c) > 0 FROM Comment c where c.message = :message", Boolean.class)
                .setParameter("message", "refactoring collection")
                .getSingleResult());
    }
}