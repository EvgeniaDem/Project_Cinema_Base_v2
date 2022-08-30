package com.kata.cinema.base.webapp.controllers.collectionRestController;
import com.kata.cinema.base.AbstractIT;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/collectionRestController/CollectionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/collectionRestController/CollectionClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DeleteCollectionsIT extends AbstractIT {

    @Test
    public void deleteCollections() throws Exception {
        mockMvc.perform(delete("/api/collections/{id}", 100L))
                .andDo(print())
                .andExpect(status().isOk());

        Assert.assertTrue(entityManager.createQuery("SELECT count(c) < 1 FROM Collections c WHERE c.id = :id", Boolean.class)
                .setParameter("id", 100L).getSingleResult());
    }

    @Test
    public void deleteMovie() throws Exception {
        List<Long> movieIds = new ArrayList<>(Arrays.asList(100L, 102L));
        mockMvc.perform(delete("/api/collections/{id}/movies" , 100L)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(movieIds)))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
