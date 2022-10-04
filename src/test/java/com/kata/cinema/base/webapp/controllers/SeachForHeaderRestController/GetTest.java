package com.kata.cinema.base.webapp.controllers.SeachForHeaderRestController;

import com.kata.cinema.base.AbstractTest;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql(value = "/data/sql/controller/searchForHeaderRestController/SearchHeaderInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/searchForHeaderRestController/SearchHeaderClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetTest extends AbstractTest {

    private static String accessToken;

    @Test
    @Ignore
    public void searchHeader() throws Exception{
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        this.mockMvc.perform(get("/api/search/?filterPattern=t")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies", hasSize(3) ))
                .andExpect(jsonPath("$.movies.[0].id").value(101L))
                .andExpect(jsonPath("$.movies.[0].name").value("test1movie"))
                .andExpect(jsonPath("$.movies.[0].avgScore").value(3.0))
                .andExpect(jsonPath("$.movies.[1].id").value(102L))
                .andExpect(jsonPath("$.movies.[1].name").value("test2movie"))
                .andExpect(jsonPath("$.movies.[1].avgScore").value(5.0))
                .andExpect(jsonPath("$.movies.[2].id").value(103L))
                .andExpect(jsonPath("$.movies.[2].name").value("test3movie"))
                .andExpect(jsonPath("$.movies.[2].avgScore").value(3.25))
                .andExpect(jsonPath("$.collections", hasSize(3)))
                .andExpect(jsonPath("$.collections.[0].name").value("test1 collection"))
                .andExpect(jsonPath("$.collections.[0].url").value("preview url test 1"))
                .andExpect(jsonPath("$.collections.[1].name").value("test2 collection"))
                .andExpect(jsonPath("$.collections.[1].url").value("preview url test 2"))
                .andExpect(jsonPath("$.collections.[2].name").value("test3 collection"))
                .andExpect(jsonPath("$.collections.[2].url").value("preview url test 3"))
                .andExpect(jsonPath("$.persons", hasSize(3) ))
                .andExpect(jsonPath("$.persons.[0].id").value(101L))
                .andExpect(jsonPath("$.persons.[0].fullName").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.persons.[1].id").value(102L))
                .andExpect(jsonPath("$.persons.[1].fullName").value("test2Name test2LastName"))
                .andExpect(jsonPath("$.persons.[2].id").value(103L))
                .andExpect(jsonPath("$.persons.[2].fullName").value("test3Name test3LastName"));



    }
}