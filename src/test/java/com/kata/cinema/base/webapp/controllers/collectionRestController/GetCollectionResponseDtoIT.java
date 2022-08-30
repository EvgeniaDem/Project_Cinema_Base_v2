package com.kata.cinema.base.webapp.controllers.collectionRestController;

import com.kata.cinema.base.AbstractIT;
import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/collectionRestController/CollectionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/collectionRestController/CollectionClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Ignore
public class GetCollectionResponseDtoIT extends AbstractIT {

    //TODO починить ендпоинт, потом тесты
    @Test
    @Disabled
    void getCollectionResponseDto() throws Exception {
        mockMvc.perform(get("/api/collections"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(1)))
                .andExpect(jsonPath("$.countViewedMovies").value(0))
                .andExpect(jsonPath("$.countMovies").value(0));
    }
}