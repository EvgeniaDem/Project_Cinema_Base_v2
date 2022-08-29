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

import static com.kata.cinema.base.AbstractIT.GENRES_REST_CONTROLLER_CLEAR_SQL;
import static com.kata.cinema.base.AbstractIT.GENRES_REST_CONTROLLER_INIT_SQL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = GENRES_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = GENRES_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithMockUser(roles = "ADMIN")
public class UpdateIT extends AbstractIT {
    public UpdateIT() {

    }

    @Test
    public void updateGenres() throws Exception {
        this.mockMvc.perform(put("/api/admin/genres/3?name=Test2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateGenresWithoutId() throws Exception {
        this.mockMvc.perform(put("/api/admin/genres?name=Test2"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void updateGenresWithoutName() throws Exception {
        this.mockMvc.perform(put("/api/admin/genres/4"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }
}
