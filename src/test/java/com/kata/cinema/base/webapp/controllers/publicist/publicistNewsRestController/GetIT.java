package com.kata.cinema.base.webapp.controllers.publicist.publicistNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kata.cinema.base.AbstractIT.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = PUBLICIST_NEWS_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = PUBLICIST_NEWS_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithMockUser(roles = "PUBLICIST")
public class GetIT extends AbstractIT {

    @Test
    public void getNews() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewsWithAllParameters() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&endDate=2022-08-05&rubric=NEWS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyDate() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&endDate=2022-08-05"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-05"))
                .andExpect(jsonPath("$.[1].title").value("db test title 03"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyStartDate() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-05"))
                .andExpect(jsonPath("$.[1].title").value("db test title 03"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyEndDate() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?endDate=2022-08-04"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-03"))
                .andExpect(jsonPath("$.[0].title").value("db test title 01"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[1].title").value("db test title 02"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyRubric() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?rubric=TESTS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-05"))
                .andExpect(jsonPath("$.[0].title").value("db test title 03"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyStartDateAndRubric() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&rubric=NEWS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyEndDateAndRubric() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?endDate=2022-08-05&rubric=NEWS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-03"))
                .andExpect(jsonPath("$.[0].title").value("db test title 01"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[1].title").value("db test title 02"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

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
