package com.kata.cinema.base.webapp.controllers.collectionRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/collectionRestController/CollectionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/collectionRestController/CollectionClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class ActivateIT extends AbstractIT {
    @Test
    public void activate() throws Exception {
        this.mockMvc.perform(patch("/api/collections/{id}/activate" , 100))
                .andDo(print())
                .andExpect(status().isOk());
        //TODO select запрос для проверки на смену статуса
    }
}
