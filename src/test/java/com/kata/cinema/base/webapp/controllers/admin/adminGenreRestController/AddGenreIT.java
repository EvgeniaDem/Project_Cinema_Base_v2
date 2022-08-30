package com.kata.cinema.base.webapp.controllers.admin.adminGenreRestController;

import com.kata.cinema.base.AbstractIT;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/adminGenresRestController/GenresInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminGenresRestController/GenresClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AddGenreIT extends AbstractIT {

    private static String accessToken;

    @Test
    public void createGenres() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);

        String name = "TEST4";
        mockMvc.perform(post("/api/admin/genres")
                        .header("Authorization", "Bearer " + accessToken)
                        .param("name", name))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertTrue(entityManager.createQuery("SELECT count(g) > 0 FROM Genres g WHERE g.name = :name", Boolean.class)
                .setParameter("name", name).getSingleResult());
    }

    @Test
    @Ignore
    public void createGenres_uniqueName() throws Exception {
        //TODO тут должен быть случай с созданием жанров, когда такое имя уже есть
    }
}
