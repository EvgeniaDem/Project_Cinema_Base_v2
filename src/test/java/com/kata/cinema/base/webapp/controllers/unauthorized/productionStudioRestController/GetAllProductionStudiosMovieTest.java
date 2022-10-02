package com.kata.cinema.base.webapp.controllers.unauthorized.productionStudioRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/productionStudioRestController/getAllProductionStudiosMovie/GetAllProductionStudiosMovieInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/productionStudioRestController/getAllProductionStudiosMovie/GetAllProductionStudiosMovieClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetAllProductionStudiosMovieTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void getMovieWithAllStudios() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/1/studios")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(10)))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].name").value("studio1"))
                .andExpect(jsonPath("$.[0].performance.id").value(1L))
                .andExpect(jsonPath("$.[0].performance.name").value("montage"))
                .andExpect(jsonPath("$.[1].id").value(2L))
                .andExpect(jsonPath("$.[1].name").value("studio2"))
                .andExpect(jsonPath("$.[1].performance.id").value(2L))
                .andExpect(jsonPath("$.[1].performance.name").value("draw"))
                .andExpect(jsonPath("$.[2].id").value(3L))
                .andExpect(jsonPath("$.[2].name").value("studio3"))
                .andExpect(jsonPath("$.[2].performance.id").value(3L))
                .andExpect(jsonPath("$.[2].performance.name").value("producing"))
                .andExpect(jsonPath("$.[3].id").value(4L))
                .andExpect(jsonPath("$.[3].name").value("studio4"))
                .andExpect(jsonPath("$.[3].performance.id").value(4L))
                .andExpect(jsonPath("$.[3].performance.name").value("scenario"))
                .andExpect(jsonPath("$.[4].id").value(5L))
                .andExpect(jsonPath("$.[4].name").value("studio5"))
                .andExpect(jsonPath("$.[4].performance.id").value(5L))
                .andExpect(jsonPath("$.[4].performance.name").value("directing"))
                .andExpect(jsonPath("$.[5].id").value(6L))
                .andExpect(jsonPath("$.[5].name").value("studio6"))
                .andExpect(jsonPath("$.[5].performance.id").value(5L))
                .andExpect(jsonPath("$.[5].performance.name").value("directing"))
                .andExpect(jsonPath("$.[6].id").value(7L))
                .andExpect(jsonPath("$.[6].name").value("studio7"))
                .andExpect(jsonPath("$.[6].performance.id").value(4L))
                .andExpect(jsonPath("$.[6].performance.name").value("scenario"))
                .andExpect(jsonPath("$.[7].id").value(8L))
                .andExpect(jsonPath("$.[7].name").value("studio8"))
                .andExpect(jsonPath("$.[7].performance.id").value(3L))
                .andExpect(jsonPath("$.[7].performance.name").value("producing"))
                .andExpect(jsonPath("$.[8].id").value(9L))
                .andExpect(jsonPath("$.[8].name").value("studio9"))
                .andExpect(jsonPath("$.[8].performance.id").value(2L))
                .andExpect(jsonPath("$.[8].performance.name").value("draw"))
                .andExpect(jsonPath("$.[9].id").value(10L))
                .andExpect(jsonPath("$.[9].name").value("studio10"))
                .andExpect(jsonPath("$.[9].performance.id").value(1L))
                .andExpect(jsonPath("$.[9].performance.name").value("montage"));
    }

    @Test
    public void getMovieWithoutStudios() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/2/studios")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(0)));
    }

    @Test
    public void getMovieWithOneStudio() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/5/studios")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(1)))
                .andExpect(jsonPath("$.[0].id").value(15L))
                .andExpect(jsonPath("$.[0].name").value("studio5"))
                .andExpect(jsonPath("$.[0].performance.id").value(5L))
                .andExpect(jsonPath("$.[0].performance.name").value("directing"));
    }

    @Test
    public void getRandomMovieWithStudios() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/movies/8/studios")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$.[0].id").value(22L))
                .andExpect(jsonPath("$.[0].name").value("studio2"))
                .andExpect(jsonPath("$.[0].performance.id").value(5L))
                .andExpect(jsonPath("$.[0].performance.name").value("directing"))
                .andExpect(jsonPath("$.[1].id").value(24L))
                .andExpect(jsonPath("$.[1].name").value("studio4"))
                .andExpect(jsonPath("$.[1].performance.id").value(1L))
                .andExpect(jsonPath("$.[1].performance.name").value("montage"));
    }
}