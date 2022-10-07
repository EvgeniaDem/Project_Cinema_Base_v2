package com.kata.cinema.base.webapp.controllers.unauthorized.excertionRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/excertionRestController/ExcertionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/excertionRestController/ExcertionClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PutExcertionTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void updateExcertion() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        ExcertionRequestDto excertionRequestDto = new ExcertionRequestDto("Test666");
        mockMvc.perform(put("/api/excertions/{id}", 1L)
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(objectMapper.writeValueAsString(excertionRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertEquals("Test666",
                entityManager.createQuery("SELECT ex.description FROM Excertion ex WHERE ex.id = :id", String.class)
                        .setParameter("id", 1L)
                        .getSingleResult());
    }

    @Test
    public void updateExcertionWithWrongId() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        ExcertionRequestDto excertionRequestDto = new ExcertionRequestDto("Test666");
        mockMvc.perform(put("/api/excertions/{id}", 666L)
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(objectMapper.writeValueAsString(excertionRequestDto)))
                .andExpect(jsonPath("$.text").value("Выдержки с id: 666 не существует"));
    }
}