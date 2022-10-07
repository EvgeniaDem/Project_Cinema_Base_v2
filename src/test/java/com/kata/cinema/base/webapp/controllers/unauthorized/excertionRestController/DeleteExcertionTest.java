package com.kata.cinema.base.webapp.controllers.unauthorized.excertionRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/excertionRestController/ExcertionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/excertionRestController/ExcertionClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DeleteExcertionTest extends AbstractTest {
    private static String accessToken;

    @Test
    public void deleteExcertion() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(delete("/api/excertions/{id}", 1L)
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertTrue("Удаления не произошло",
                entityManager.createQuery("SELECT count(ex) = 1 FROM Excertion ex", Boolean.class)
                        .getSingleResult());
    }

    @Test
    public void deleteExcertionWithWrongId() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/excertions/{id}", 666L)
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(jsonPath("$.text").value("Выдержки с id: 666 не существует"));
    }
}
