package com.kata.cinema.base.webapp.controllers.publicist.publicistNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql(value = "/data/sql/controller/publicistNewsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/publicistNewsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CreateNewsIT extends AbstractIT {

    private static String accessToken;

    @Test
    public void createNews() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        NewsRequestDto newsRequestDto = new NewsRequestDto(Rubric.NEWS, "TipoTitleTest", "TipoHtmlTest");
        this.mockMvc.perform(post("/api/publicist/news")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(objectMapper.writeValueAsString(newsRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
        //TODO селект запрос на проверку
    }
}