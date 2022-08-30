package com.kata.cinema.base.webapp.controllers.admin.adminGenreRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/adminGenresRestController/GenresInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminGenresRestController/GenresClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DeleteGenresIT extends AbstractIT {

    private static String accessToken;

    @Test
    public void deleteGenres() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/genres/{id}", 100L)
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());
        Assert.assertTrue(entityManager.createQuery("SELECT count(g) < 1 FROM Genres g WHERE g.id = :id", Boolean.class)
                .setParameter("id", 100L).getSingleResult());
    }

    @Test
    public void deleteGenreWithWrongId() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/genres/{id}", 45L)
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isInternalServerError());
    }
}
