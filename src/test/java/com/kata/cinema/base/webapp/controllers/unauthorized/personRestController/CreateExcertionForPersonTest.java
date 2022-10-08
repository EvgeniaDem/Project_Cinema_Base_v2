package com.kata.cinema.base.webapp.controllers.unauthorized.personRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/personRestController/ExcertionForPersonInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/personRestController/ExcertionForPersonClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CreateExcertionForPersonTest extends AbstractTest {
    private static String accessToken;

    @Test
    public void createExcertionForPerson() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        ExcertionRequestDto excertionRequestDto = new ExcertionRequestDto("Test21");
        mockMvc.perform(post("/api/persons/1/excertions")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(objectMapper.writeValueAsString(excertionRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());

        Assert.assertTrue("Неудалось создать выдержку",
                entityManager.createQuery("SELECT count(ex) = 21 FROM Excertion ex", Boolean.class)
                .getSingleResult());
    }
}
