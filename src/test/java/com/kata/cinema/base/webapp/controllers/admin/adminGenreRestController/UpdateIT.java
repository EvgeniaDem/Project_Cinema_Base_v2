package com.kata.cinema.base.webapp.controllers.admin.adminGenreRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/adminGenresRestController/GenresInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminGenresRestController/GenresClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UpdateIT extends AbstractIT {

    private static String accessToken;

    @Test
    public void updateGenres() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(put("/api/admin/genres/{id}", 100)
                        .param("name", "Test2")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertEquals("Test2", entityManager.createQuery("SELECT g.name FROM Genres g WHERE g.id = :id", String.class)
                .setParameter("id", 100L).getSingleResult());
    }

    @Test
    public void updateGenres_badId() throws Exception {
        //TODO Тут должен быть случай с несуществующим id
    }
}
