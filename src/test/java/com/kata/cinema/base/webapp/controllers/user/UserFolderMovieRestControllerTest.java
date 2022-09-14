package com.kata.cinema.base.webapp.controllers.user;

import com.kata.cinema.base.models.entitys.FolderMovie;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.kata.cinema.base.models.enums.Category.CUSTOM;
import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;
import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = "/data/sql/controller/userNewsRestController/UserNewsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)


//TODO переделать, как остальные тесты
public class UserFolderMovieRestControllerTest extends AbstractTest {
    private static String accessToken;

    @Test
    public void getFolderMovieResponseDto() throws Exception {
        accessToken = obtainNewAccessToken("user@mail.ru", "user", mockMvc);
        this.mockMvc.perform(get("/api/user/folders")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Is.is(1)))
                .andExpect(jsonPath("$.[0].id").value(100L))
                .andExpect(jsonPath("$.[0].name").value("some test name"))
                .andExpect(jsonPath("$.[0].category").value("CUSTOM"))
                .andExpect(jsonPath("$.[0].countMovies").value(1));
    }

    @Test
    public void addNewFolderMovie() throws Exception{
        accessToken = obtainNewAccessToken("user@mail.ru", "user", mockMvc);
        FolderMovie folderMovie = new FolderMovie(101L,CUSTOM,PUBLIC,"comedy","description 2");
        this.mockMvc.perform(post("/api/user/folders")
                .header("Authorization", "Bearer " + accessToken)
                        .contentType("application/json")
                .content(objectMapper.writeValueAsString(folderMovie)))
                .andDo(print());
    }
}