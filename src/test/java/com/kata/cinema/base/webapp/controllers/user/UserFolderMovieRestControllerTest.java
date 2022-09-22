package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.entitys.FolderMovie;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;


import static com.kata.cinema.base.models.enums.Category.CUSTOM;
import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;
import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/userFolderMovieRestController/getUserFolderMovies/GetUserFolderMoviesInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class UserFolderMovieRestControllerTest extends AbstractTest {
    private static String accessToken;

    @Test
    public void getFolderMovieResponseDto() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        this.mockMvc.perform(get("/api/user/folders")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(5)))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].name").value("folder1"))
                .andExpect(jsonPath("$.[0].category").value("VIEWED_MOVIES"))
                .andExpect(jsonPath("$.[0].countMovies").value(0))
                .andExpect(jsonPath("$.[1].id").value(2L))
                .andExpect(jsonPath("$.[1].name").value("folder2"))
                .andExpect(jsonPath("$.[1].category").value("WAITING_MOVIES"))
                .andExpect(jsonPath("$.[1].countMovies").value(0))
                .andExpect(jsonPath("$.[2].id").value(3L))
                .andExpect(jsonPath("$.[2].name").value("folder3"))
                .andExpect(jsonPath("$.[2].category").value("FAVORITE_MOVIES"))
                .andExpect(jsonPath("$.[2].countMovies").value(0));
    }

    @Test
    public void addNewFolderMovie() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        FolderMovie folderMovie = new FolderMovie(101L, CUSTOM, PUBLIC, "comedy", "description 2");
        this.mockMvc.perform(post("/api/user/folders")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(folderMovie)))
                .andDo(print());

        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        FolderMovie folderMovie1 = new FolderMovie(101L, CUSTOM, PUBLIC, "comedy", "description 2");//попытка создания с одинаковым id
        this.mockMvc.perform(post("/api/user/folders")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(folderMovie1)))
                .andExpect(status().isInternalServerError());
    }
}