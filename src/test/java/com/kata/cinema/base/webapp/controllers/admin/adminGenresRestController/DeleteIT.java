package com.kata.cinema.base.webapp.controllers.admin.adminGenresRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.kata.cinema.base.AbstractIT.GENRES_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.GENRES_REST_CONTROLLER_INIT_SQL;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = GENRES_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = GENRES_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithMockUser(roles = "ADMIN")
public class DeleteIT extends AbstractIT {
    public DeleteIT() {

    }

    @Test
    public void deleteGenres() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/genres/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteGenreWithWrongId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/genres/{id}", 45L))
                .andDo(print()).andExpect(status().isInternalServerError());
    }
}
