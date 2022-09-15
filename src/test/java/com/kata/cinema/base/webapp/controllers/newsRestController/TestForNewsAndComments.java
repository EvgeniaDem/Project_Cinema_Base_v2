package com.kata.cinema.base.webapp.controllers.newsRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Sql(value = "/data/sql/controller/newsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/newsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TestForNewsAndComments extends AbstractTest {
    @Test
    public void compareResults() throws Exception {
        String[] content = getResult().getResponse().getContentAsString().replaceAll("[\"{}]","").split(",");
        Map<String, Object> resultMap = Arrays.stream(content).collect(HashMap::new, (x, y) -> {
            String [] pair = y.split(":");
            x.put(pair[0], pair[1]);
        },HashMap::putAll);
        mockMvc.perform(get("/api/news/1/comments"))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(resultMap.get("countComment")));
    }

    protected MvcResult getResult() throws Exception {
        return mockMvc.perform(get("/api/news/1"))
                .andDo(print())
                .andReturn();
    }
}
