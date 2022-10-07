package com.kata.cinema.base.webapp.controllers.unauthorized.personRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/personRestController/ExcertionForPersonInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/personRestController/ExcertionForPersonClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetExcertionsForPersonTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void getFirstPageWithExcertionsForPerson() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/persons/1/excertions/page/1?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(5)))
                .andExpect(jsonPath("$.entities.[0].id").value(204))
                .andExpect(jsonPath("$.entities.[0].description").value("Test2"))
                .andExpect(jsonPath("$.entities.[0].id").value(208))
                .andExpect(jsonPath("$.entities.[0].description").value("Test10"))
                .andExpect(jsonPath("$.entities.[0].id").value(209))
                .andExpect(jsonPath("$.entities.[0].description").value("Test12"))
                .andExpect(jsonPath("$.entities.[0].id").value(210))
                .andExpect(jsonPath("$.entities.[0].description").value("Test14"))
                .andExpect(jsonPath("$.entities.[0].id").value(211))
                .andExpect(jsonPath("$.entities.[0].description").value("Test16"));
    }

    @Test
    public void getLastPageWithExcertionsForPerson() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/persons/1/excertions/page/2?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(2)))
                .andExpect(jsonPath("$.entities.[0].id").value(212))
                .andExpect(jsonPath("$.entities.[0].description").value("Test18"))
                .andExpect(jsonPath("$.entities.[0].id").value(213))
                .andExpect(jsonPath("$.entities.[0].description").value("Test20"));
    }

    @Test
    public void getFirstPageWithExcertionsForOtherPerson() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/persons/2/excertions/page/1?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(1)))
                .andExpect(jsonPath("$.entities.[0].id").value(205))
                .andExpect(jsonPath("$.entities.[0].description").value("Test4"));
    }
}