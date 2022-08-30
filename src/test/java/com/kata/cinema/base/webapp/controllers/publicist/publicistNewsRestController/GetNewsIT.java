package com.kata.cinema.base.webapp.controllers.publicist.publicistNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.*;
import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql(value = "/data/sql/controller/publicistNewsRestController/NewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/publicistNewsRestController/NewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetNewsIT extends AbstractIT {

    private static String accessToken;

    @Test
    public void getNews() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());
        //TODO проверять больше данных
    }

    @Test
    public void getNewsWithAllParameters() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&endDate=2022-08-05&rubric=NEWS")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("04.08.2022"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
        //TODO проверять больше данных
    }

    @Test
    public void getNewsWithOnlyDate() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&endDate=2022-08-05")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("04.08.2022"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[1].date").value("05.08.2022"))
                .andExpect(jsonPath("$.[1].title").value("db test title 03"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
        //TODO проверять больше данных
    }

    @Test
    public void getNewsWithOnlyStartDate() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("04.08.2022"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[1].date").value("05.08.2022"))
                .andExpect(jsonPath("$.[1].title").value("db test title 03"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
        //TODO проверять больше данных
    }

    @Test
    public void getNewsWithOnlyEndDate() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?endDate=2022-08-04")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("03.08.2022"))
                .andExpect(jsonPath("$.[0].title").value("db test title 01"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[1].date").value("04.08.2022"))
                .andExpect(jsonPath("$.[1].title").value("db test title 02"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
        //TODO проверять больше данных
    }

    @Test
    public void getNewsWithOnlyRubric() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?rubric=TESTS")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[0].date", Is.is("05.08.2022")))
                .andExpect(jsonPath("$.[0].title").value("db test title 03"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
        //TODO проверять больше данных
    }

    @Test
    public void getNewsWithOnlyStartDateAndRubric() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&rubric=NEWS")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("04.08.2022"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyEndDateAndRubric() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        mockMvc.perform(get("/api/publicist/news?endDate=2022-08-05&rubric=NEWS")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("03.08.2022"))
                .andExpect(jsonPath("$.[0].title").value("db test title 01"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[1].date").value("04.08.2022"))
                .andExpect(jsonPath("$.[1].title").value("db test title 02"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    public void createNews() throws Exception {
        accessToken = obtainNewAccessToken("publicist@mail.ru", "password", mockMvc);
        NewsRequestDto newsRequestDto = new NewsRequestDto(Rubric.NEWS, "TipoTitleTest", "TipoHtmlTest");
        this.mockMvc.perform(post("/api/publicist/news")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newsRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
