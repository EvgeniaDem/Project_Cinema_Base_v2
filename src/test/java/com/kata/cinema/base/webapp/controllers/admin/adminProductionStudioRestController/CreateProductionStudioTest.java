package com.kata.cinema.base.webapp.controllers.admin.adminProductionStudioRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/adminProductionStudioRestController/PostProductionStudioInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminProductionStudioRestController/ProductionStudioClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CreateProductionStudioTest extends AbstractTest {
    private static String accessToken;

    @Test
    public void createProductionStudio() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        ProductionStudioRequestDto productionStudioRequestDto = new ProductionStudioRequestDto("studio1", "description1", LocalDate.now());
        mockMvc.perform(post("/api/admin/studios")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(objectMapper.writeValueAsString(productionStudioRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());

        Assert.assertTrue(entityManager.createQuery("SELECT count(ps) = 1 FROM ProductionStudio ps", Boolean.class)
                .getSingleResult());
    }
}
