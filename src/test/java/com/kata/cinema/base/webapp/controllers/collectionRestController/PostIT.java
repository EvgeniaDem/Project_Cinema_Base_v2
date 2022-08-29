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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.kata.cinema.base.models.enums.CollectionType.MOVIES;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")

public class PostIT extends AbstractIT {

    public PostIT() {
    }

    @Test
    public void postCollectionResponseDto() throws Exception {
        CollectionRequestDto collectionRequestDto = new CollectionRequestDto("new collection", MOVIES);
        this.mockMvc.perform(post("/api/collections/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(collectionRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Sql(value = COLLECTION_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = COLLECTION_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void addMovie() throws Exception {
        List<Long> movieIds = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L,6L));
        this.mockMvc.perform(post("/api/collections/{id}/movies" , 1L)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(movieIds)))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
