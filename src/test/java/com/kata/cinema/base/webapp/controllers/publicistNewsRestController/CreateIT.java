package com.kata.cinema.base.webapp.controllers.publicistNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.*;
import static com.kata.cinema.base.AbstractIT.PUBLICIST_NEWS_REST_CONTROLLER_CLEAR_SQL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = PUBLICIST_NEWS_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = PUBLICIST_NEWS_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CreateIT extends AbstractIT {
    @Test
    public void createNews() throws Exception {
        NewsRequestDto newsRequestDto = new NewsRequestDto(Rubric.NEWS, "TipoTitleTest", "TipoHtmlTest");
        this.mockMvc.perform(post("/api/publicist/news")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newsRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}