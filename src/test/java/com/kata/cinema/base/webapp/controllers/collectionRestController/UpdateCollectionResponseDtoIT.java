package com.kata.cinema.base.webapp.controllers.collectionRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.CollectionRequestDto;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.models.enums.CollectionType.MOVIES;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/collectionRestController/CollectionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/collectionRestController/CollectionClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UpdateCollectionResponseDtoIT extends AbstractIT {

    @Test
    public void updateCollectionResponseDto() throws Exception {
        CollectionRequestDto collectionRequestDto = new CollectionRequestDto("refactoring collection", MOVIES);
        this.mockMvc.perform(put("/api/collections/{id}", 100)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(collectionRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
        //TODO селект запрос на проверку
    }
}
