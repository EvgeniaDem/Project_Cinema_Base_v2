package com.kata.cinema.base.webapp.controllers.publicist.publicistNewsRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@Sql(value = "/data/sql/controller/publicistNewsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/publicistNewsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CreateNewsTest extends AbstractTest {

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
        Assert.assertTrue(entityManager.createQuery("SELECT count(n) > 0 FROM News n WHERE n.rubric =:rubric and n.title = :title and n.htmlBody = :htmlBody", Boolean.class)
                        .setParameter("rubric", Rubric.NEWS)
                        .setParameter("title", "TipoTitleTest")
                        .setParameter("htmlBody", "TipoHtmlTest")
                        .getSingleResult());
    }
}