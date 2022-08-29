package com.kata.cinema.base.webapp.controllers.collectionRestController;
import com.kata.cinema.base.AbstractIT;
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
import static com.kata.cinema.base.AbstractIT.COLLECTION_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.COLLECTION_REST_CONTROLLER_INIT_SQL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = COLLECTION_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = COLLECTION_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DeleteIT extends AbstractIT {

    @Test
    public void deleteCollections() throws Exception {
        mockMvc.perform(delete("/api/collections/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteMovie() throws Exception {
        List<Long> movieIds = new ArrayList<>(Arrays.asList(1L,3L));
        this.mockMvc.perform(delete("/api/collections/{id}/movies" , 1L)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(movieIds)))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
