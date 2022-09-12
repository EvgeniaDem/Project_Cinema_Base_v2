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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.kata.cinema.base.models.enums.Category.CUSTOM;
import static com.kata.cinema.base.models.enums.Privacy.PUBLIC;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
//TODO переделать, как остальные тесты
public class UserFolderMovieRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserFolderMovieRestController userFolderMovieRestController;

    public UserFolderMovieRestControllerTest() {
    }


    @Test
    public void getFolderMovieResponseDto() throws Exception {
        try {
            userFolderMovieRestController.getFolderMovieResponseDto();
        }catch (Exception e){
            Assert.fail("При тестировании получения List<FolderResponseDto> произошла ошибка\n" + e);
        }
    }
    @Test
    public void addNewFolderMovie() {
        FolderMovie folderMovie = new FolderMovie(2L, CUSTOM, PUBLIC,"marriage","comedy");
        try {
            userFolderMovieRestController.addNewFolderMovie(folderMovie);
        }catch (Exception e){
            Assert.fail("При тестировании создания FolderResponseDto произошло исключение\n" + e);
        }
    }
}