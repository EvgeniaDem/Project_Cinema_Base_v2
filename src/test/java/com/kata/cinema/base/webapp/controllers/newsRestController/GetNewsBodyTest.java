package com.kata.cinema.base.webapp.controllers.newsRestController;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Sql(value = "/data/sql/controller/newsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/newsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetNewsBodyTest extends AbstractTest {
    @Test
    public void getBody() throws Exception {
        mockMvc.perform(get("/api/news/100"))
                .andDo(print())
                .andExpect(jsonPath("$.length()", Is.is(7)))
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.countComment").value(2))
                .andExpect(jsonPath("$.rubric").value("NEWS"))
                .andExpect(jsonPath("$.authorName").value("1 1"))
                .andExpect(jsonPath("$.title").value("db test title 01"))
                .andExpect(jsonPath("$.htmlBody").value("nytipobody"))
                .andExpect(jsonPath("$.date").value("03.08.2022"));
    }

    @Test
    public void getWithWrongId() throws Exception {
        mockMvc.perform(get("/api/news/10"))
                .andDo(print())
                .andExpect(jsonPath("$.text").value("News with id: 10 does not exist, try looking for another"));
    }
}
