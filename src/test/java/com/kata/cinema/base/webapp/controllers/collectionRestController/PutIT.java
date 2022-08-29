package com.kata.cinema.base.webapp.controllers.collectionRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.CollectionRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.COLLECTION_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.COLLECTION_REST_CONTROLLER_INIT_SQL;
import static com.kata.cinema.base.models.enums.CollectionType.MOVIES;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = COLLECTION_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = COLLECTION_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PutIT extends AbstractIT {

    @Test
    public void updateCollectionResponseDto() throws Exception {
        CollectionRequestDto collectionRequestDto = new CollectionRequestDto("refactoring collection", MOVIES);
        this.mockMvc.perform(put("/api/collections/{id}", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(collectionRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
