package com.kata.cinema.base.webapp.controllers.admin.adminProductionStudioRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/adminProductionStudioRestController/PutProductionStudioInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminProductionStudioRestController/ProductionStudioClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PutProductionStudioTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void updateProductionStudio() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        String productionStudio = "{\"name\": \"studioTest\", \"description\": \"description1\", \"dateFoundation\": \"2022-08-23\"}";
        mockMvc.perform(put("/api/admin/studios/{id}", 1L)
                        .header("Authorization", "Bearer " + accessToken)
                        .content(productionStudio))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertEquals("studioTest",
                entityManager.createQuery("SELECT ps.name FROM ProductionStudio ps WHERE ps.id = :id", String.class)
                        .setParameter("id", 1L)
                        .getSingleResult());
    }

    @Test
    public void updateProductionStudioWithWrongId() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(put("/api/admin/studios/{id}", 666L)
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(jsonPath("$.text").value("There is no production studio with ID: 666, try again."));
    }
}