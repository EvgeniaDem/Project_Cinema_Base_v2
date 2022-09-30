package com.kata.cinema.base.webapp.controllers.collectionRestController;

import com.kata.cinema.base.AbstractTest;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/collectionRestController/CollectionInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/collectionRestController/CollectionClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetPageDtoOfCollectionMoviesResponseDtoTest extends AbstractTest {


    @Test
    public void getPageDtoOfCollectionMoviesResponseDto1() throws Exception {
        this.mockMvc.perform(get("/api/collections/100/movies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.entities.[0].id").value(100L))
                .andExpect(jsonPath("$.entities.[0].collectionName").value("myCollectionTest"))
                .andExpect(jsonPath("$.entities.[0].description").value("myDescription"))
                .andExpect(jsonPath("$.entities.[0].collectionUrl").value("test_URL"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].id").value(101L))
                .andExpect(jsonPath("$.entities.[0].movies.[0].name").value("wood"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].originalName").value("wood"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].time").value(9600))
                .andExpect(jsonPath("$.entities.[0].movies.[0].dateRelease").value("09.08.2022"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].countries").value("test_countries"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].genres").value("genre 1"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].director").value("актер"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].roles").value("role2"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].id").value(100L))
                .andExpect(jsonPath("$.entities.[0].movies.[1].name").value("DOOM"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].originalName").value("doom"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].time").value(9600))
                .andExpect(jsonPath("$.entities.[0].movies.[1].dateRelease").value("09.08.2021"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].countries").value("test_countries1"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].genres").value("genre 1"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].director").value("director_100"))
                .andExpect(jsonPath("$.entities.[0].movies.[1].roles").value("role1"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].id").value(100L))
                .andExpect(jsonPath("$.entities.[0].movies.[2].name").value("DOOM"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].originalName").value("doom"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].time").value(9600))
                .andExpect(jsonPath("$.entities.[0].movies.[2].dateRelease").value("09.08.2021"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].countries").value("test_countries1"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].genres").value("genre 1"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].director").value("director_100"))
                .andExpect(jsonPath("$.entities.[0].movies.[2].roles").value("role3"));
    }

    @Test
    public void getPageDtoOfCollectionMoviesResponseDto2() throws Exception {
        this.mockMvc.perform(get("/api/collections/100/movies?country=test_countries"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.entities.[0].id").value(100L))
                .andExpect(jsonPath("$.entities.[0].collectionName").value("myCollectionTest"))
                .andExpect(jsonPath("$.entities.[0].description").value("myDescription"))
                .andExpect(jsonPath("$.entities.[0].collectionUrl").value("test_URL"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].id").value(101L))
                .andExpect(jsonPath("$.entities.[0].movies.[0].name").value("wood"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].originalName").value("wood"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].time").value(9600))
                .andExpect(jsonPath("$.entities.[0].movies.[0].dateRelease").value("09.08.2022"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].countries").value("test_countries"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].genres").value("genre 1"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].director").value("актер"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].roles").value("role2"));
    }

    @Test
    public void getPageDtoOfCollectionMoviesResponseDto3() throws Exception {
        this.mockMvc.perform(get("/api/collections/100/movies?date=2022-08-09"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(2)))
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.entities.[0].id").value(100L))
                .andExpect(jsonPath("$.entities.[0].collectionName").value("myCollectionTest"))
                .andExpect(jsonPath("$.entities.[0].description").value("myDescription"))
                .andExpect(jsonPath("$.entities.[0].collectionUrl").value("test_URL"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].id").value(101L))
                .andExpect(jsonPath("$.entities.[0].movies.[0].name").value("wood"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].originalName").value("wood"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].time").value(9600))
                .andExpect(jsonPath("$.entities.[0].movies.[0].dateRelease").value("09.08.2022"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].countries").value("test_countries"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].genres").value("genre 1"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].director").value("актер"))
                .andExpect(jsonPath("$.entities.[0].movies.[0].roles").value("role2"));
    }

}
