package com.kata.cinema.base.webapp.controllers.admin.adminProductionStudioRestController;

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

@Sql(value = "/data/sql/controller/adminProductionStudioRestController/DeleteProductionStudioInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminProductionStudioRestController/ProductionStudioClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DeleteProductionStudioTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void deleteProductionStudio() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(delete("/api/admin/studios/{id}", 1L)
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertTrue("studio1",
                entityManager.createQuery("SELECT count(ps) = 0 FROM ProductionStudio ps", Boolean.class)
                        .getSingleResult());
    }

    @Test
    public void deleteProductionStudioWithWrongId() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/studios/{id}", 666L)
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(jsonPath("$.text").value("There is no production studio with ID: 666, try again."));
    }
}