package com.kata.cinema.base.webapp.controllers.userNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static com.kata.cinema.base.AbstractIT.*;
import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AddCommentsIT extends AbstractIT {

    private static String accessToken;

    @Test
    @Disabled
    public void createComment() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "password", mockMvc);
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        mockMvc.perform(post("/api/user/news/100/comments?userId=100")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());

        //TODO проверка через селект запрос
    }

    @Test
    @Disabled
    public void createCommentWithWrongNewsId() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "password", mockMvc);
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        mockMvc.perform(post("/api/user/news/6/comments?userId=2")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    @Disabled
    public void createCommentWithWrongUserId() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "password", mockMvc);
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        mockMvc.perform(post("/api/user/news/2/comments?userId=5")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }
}
