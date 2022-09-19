package com.kata.cinema.base.webapp.controllers.admin.adminGenreRestController;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql(value = "/data/sql/controller/adminGenresRestController/GenresInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminGenresRestController/GenresClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetGenresTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void getGenres() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        this.mockMvc.perform(get("/api/admin/genres")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(3)))
                .andExpect(jsonPath("$.[0].id").value(100L))
                .andExpect(jsonPath("$.[0].name").value("TEST1"))
                .andExpect(jsonPath("$.[1].id").value(200L))
                .andExpect(jsonPath("$.[1].name").value("TEST2"))
                .andExpect(jsonPath("$.[2].id").value(300L))
                .andExpect(jsonPath("$.[2].name").value("TEST3"));

    }
}