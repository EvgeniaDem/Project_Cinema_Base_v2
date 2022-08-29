package com.kata.cinema.base.webapp.controllers.userNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import org.junit.Test;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = USER_NEWS_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = USER_NEWS_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithMockUser(roles = "USER")
public class CreateIT extends AbstractIT {
    @Test
    public void createComment() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        this.mockMvc.perform(post("/api/user/news/2/comments?userId=2")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createCommentWithWrongNewsId() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        this.mockMvc.perform(post("/api/user/news/6/comments?userId=2")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void createCommentWithWrongUserId() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        this.mockMvc.perform(post("/api/user/news/2/comments?userId=5")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }
}
