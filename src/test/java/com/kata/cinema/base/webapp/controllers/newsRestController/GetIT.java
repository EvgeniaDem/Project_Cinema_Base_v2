package com.kata.cinema.base.webapp.controllers.newsRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.NEWS_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.NEWS_REST_CONTROLLER_INIT_SQL;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = NEWS_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = NEWS_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetIT extends AbstractIT {
    @Test
    public void getComments() throws Exception {
        this.mockMvc.perform(get("/api/news/1/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].id").value(1));
    }

    @Test
    public void getCommentWithWrongId() throws Exception {
        this.mockMvc.perform(get("/api/news/10/comments"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void getCommentsWithSeveralNews() throws Exception {
        this.mockMvc.perform(get("/api/news/1/2/3/comments"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
