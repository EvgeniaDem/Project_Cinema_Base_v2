package com.kata.cinema.base.webapp.controllers.newsRestController;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/newsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/newsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetListOfCommentsIT extends AbstractTest {

    @Test
    public void getComments() throws Exception {
        mockMvc.perform(get("/api/news/100/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(1)))
                .andExpect(jsonPath("$.[0].id").value(100));
        //TODO Добавить больше данных и проверять их
    }

    @Test
    public void getCommentWithWrongId() throws Exception {
        mockMvc.perform(get("/api/news/10/comments"))
                .andDo(print())
                .andExpect(jsonPath("$.text").value("News with id: 10 does not exist, try looking for another"));
    }
}
