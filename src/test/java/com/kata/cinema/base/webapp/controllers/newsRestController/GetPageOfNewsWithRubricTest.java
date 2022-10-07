package com.kata.cinema.base.webapp.controllers.newsRestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

@Sql(value = "/data/sql/controller/newsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/newsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetPageOfNewsWithRubricTest extends AbstractTest {
    @Test
    public void getPageWithoutParameters() throws Exception {
        mockMvc.perform(get("/api/news/page/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.length()", Is.is(3)))
                .andExpect(jsonPath("$.entities[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.count").value(2))
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.entities[0].description").value("description1"))
                .andExpect(jsonPath("$.entities[1].description").value("description2"))
                .andExpect(jsonPath("$.entities[0].id").value(100))
                .andExpect(jsonPath("$.entities[1].id").value(100))
                .andExpect(jsonPath("$.entities[1].countComment").value(2));
    }

    @Test
    public void getPageWithParameters() throws Exception {
        mockMvc.perform(get("/api/news/page/1?itemsOnPage=5&rubric=TESTS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities.length()", Is.is(2)))
                .andExpect(jsonPath("$.entities[0].rubric").value("TESTS"))
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.entities[0].description").value("description3"))
                .andExpect(jsonPath("$.entities[1].description").value("description2"))
                .andExpect(jsonPath("$.entities[0].id").value(300))
                .andExpect(jsonPath("$.entities[1].id").value(300))
                .andExpect(jsonPath("$.entities[1].countComment").value(0));
    }
}
