package com.kata.cinema.base.webapp.controllers.SeachForHeaderRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.*;
import static javax.management.Query.value;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = SEARCH_HEADER_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = SEARCH_HEADER_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class GetIT extends AbstractIT {

    @Test
    public void searchHeader() throws Exception{
        this.mockMvc.perform(get("/api/search/?filterPattern=t"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies", hasSize(3) ))
                .andExpect(jsonPath("$.movies.[0].avgScore").value(3.0))
                .andExpect(jsonPath("$.collections", hasSize(3)))
                .andExpect(jsonPath("$.persons", hasSize(3) ));

    }
}