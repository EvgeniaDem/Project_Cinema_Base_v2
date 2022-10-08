package com.kata.cinema.base.webapp.controllers.user.userFolderMovieRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/userFolderMovieRestController/getUserFolderMovies/GetUserFolderMoviesInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/userFolderMovieRestController/getUserFolderMovies/GetUserFolderMoviesClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetUserFolderMoviesTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void getFirstPageWithoutParameters() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/user/folders/3/movies/page/1")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(10)))
                .andExpect(jsonPath("$.entities.[0].id").value(1L))
                .andExpect(jsonPath("$.entities.[0].name").value("Иезавель"))
                .andExpect(jsonPath("$.entities.[0].originalName").value("Jezebel"))
                .andExpect(jsonPath("$.entities.[0].time").value(101))
                .andExpect(jsonPath("$.entities.[0].dateRelease").value("08.05.1938"))
                .andExpect(jsonPath("$.entities.[0].countries").value("Slovakia"))
                .andExpect(jsonPath("$.entities.[0].genres").value("Драма, Ужасы, Фантастика"))
                .andExpect(jsonPath("$.entities.[0].director").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.entities.[0].roles").value("role1, role3"))
                .andExpect(jsonPath("$.entities.[4].id").value(5L))
                .andExpect(jsonPath("$.entities.[4].name").value("Три лица Евы"))
                .andExpect(jsonPath("$.entities.[4].originalName").value("The Three Faces of Eve"))
                .andExpect(jsonPath("$.entities.[4].time").value(105))
                .andExpect(jsonPath("$.entities.[4].dateRelease").value("20.01.2000"))
                .andExpect(jsonPath("$.entities.[4].countries").value("Guatemala"))
                .andExpect(jsonPath("$.entities.[4].genres").value("Детектив, Комедия, Мелодрама"))
                .andExpect(jsonPath("$.entities.[4].director").value("test4Name test4LastName"))
                .andExpect(jsonPath("$.entities.[4].roles").value("role14, role15"))
                .andExpect(jsonPath("$.entities.[9].id").value(10L))
                .andExpect(jsonPath("$.entities.[9].name").value("Бумеранг!"))
                .andExpect(jsonPath("$.entities.[9].originalName").value("Boomerang"))
                .andExpect(jsonPath("$.entities.[9].time").value(110))
                .andExpect(jsonPath("$.entities.[9].dateRelease").value("24.12.2012"))
                .andExpect(jsonPath("$.entities.[9].countries").value("Niue"))
                .andExpect(jsonPath("$.entities.[9].genres").value("Документальное, Комедия, Приключения"))
                .andExpect(jsonPath("$.entities.[9].director").value("test3Name test3LastName"))
                .andExpect(jsonPath("$.entities.[9].roles").value("role28, role29"));
    }

    @Test
    public void getLastPageWithoutParameters() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/user/folders/3/movies/page/2")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(1)))
                .andExpect(jsonPath("$.entities.[0].id").value(11L))
                .andExpect(jsonPath("$.entities.[0].name").value("Крик совы"))
                .andExpect(jsonPath("$.entities.[0].originalName").value("The Cry of the Owl"))
                .andExpect(jsonPath("$.entities.[0].time").value(111))
                .andExpect(jsonPath("$.entities.[0].dateRelease").value("28.01.1922"))
                .andExpect(jsonPath("$.entities.[0].countries").value("Kyrgyzstan"))
                .andExpect(jsonPath("$.entities.[0].genres").value("Комедия, Мелодрама, Фэнтези"))
                .andExpect(jsonPath("$.entities.[0].director").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.entities.[0].roles").value("role31, role32"));
    }

    @Test
    public void getFirstPageWithParameterItemsOnPage() throws Exception {
        accessToken = obtainNewAccessToken("user2@mail.ru", "102", mockMvc);
        mockMvc.perform(get("/api/user/folders/4/movies/page/1?itemsOnPage=6")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(6)))
                .andExpect(jsonPath("$.entities.[0].id").value(1L))
                .andExpect(jsonPath("$.entities.[0].name").value("Иезавель"))
                .andExpect(jsonPath("$.entities.[0].originalName").value("Jezebel"))
                .andExpect(jsonPath("$.entities.[0].time").value(101))
                .andExpect(jsonPath("$.entities.[0].dateRelease").value("08.05.1938"))
                .andExpect(jsonPath("$.entities.[0].countries").value("Slovakia"))
                .andExpect(jsonPath("$.entities.[0].genres").value("Драма, Ужасы, Фантастика"))
                .andExpect(jsonPath("$.entities.[0].director").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.entities.[0].roles").value("role1, role3"))
                .andExpect(jsonPath("$.entities.[1].id").value(3L))
                .andExpect(jsonPath("$.entities.[1].name").value("Исход"))
                .andExpect(jsonPath("$.entities.[1].originalName").value("Exodus"))
                .andExpect(jsonPath("$.entities.[1].time").value(103))
                .andExpect(jsonPath("$.entities.[1].dateRelease").value("24.01.1925"))
                .andExpect(jsonPath("$.entities.[1].countries").value("Venezuela"))
                .andExpect(jsonPath("$.entities.[1].genres").value("Драма, Триллер, Ужасы"))
                .andExpect(jsonPath("$.entities.[1].director").value("test2Name test2LastName"))
                .andExpect(jsonPath("$.entities.[1].roles").value("role7, role8, role9"))
                .andExpect(jsonPath("$.entities.[4].id").value(8L))
                .andExpect(jsonPath("$.entities.[4].name").value("Весь город говорит"))
                .andExpect(jsonPath("$.entities.[4].originalName").value("The Talk of the Town"))
                .andExpect(jsonPath("$.entities.[4].time").value(108))
                .andExpect(jsonPath("$.entities.[4].dateRelease").value("30.06.1916"))
                .andExpect(jsonPath("$.entities.[4].countries").value("Guadeloupe"))
                .andExpect(jsonPath("$.entities.[4].genres").value("Боевик, Комедия, Мелодрама"))
                .andExpect(jsonPath("$.entities.[4].director").value("test4Name test4LastName"))
                .andExpect(jsonPath("$.entities.[4].roles").value("role24"));
    }

    @Test
    public void getFirstPageWithParameterShowType() throws Exception {
        accessToken = obtainNewAccessToken("user3@mail.ru", "103", mockMvc);
        mockMvc.perform(get("/api/user/folders/5/movies/page/1?showType=VIEWED")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(5)))
                .andExpect(jsonPath("$.entities.[2].id").value(6L))
                .andExpect(jsonPath("$.entities.[2].name").value("Человек в сером фланелевом костюме"))
                .andExpect(jsonPath("$.entities.[2].originalName").value("The Man in the Gray Flannel Suit"))
                .andExpect(jsonPath("$.entities.[2].time").value(106))
                .andExpect(jsonPath("$.entities.[2].dateRelease").value("28.02.1926"))
                .andExpect(jsonPath("$.entities.[2].countries").value("Pakistan"))
                .andExpect(jsonPath("$.entities.[2].genres").value("Боевик, Документальное, Приключения"))
                .andExpect(jsonPath("$.entities.[2].director").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.entities.[2].roles").value("role16, role18"))
                .andExpect(jsonPath("$.entities.[3].id").value(8L))
                .andExpect(jsonPath("$.entities.[3].name").value("Весь город говорит"))
                .andExpect(jsonPath("$.entities.[3].originalName").value("The Talk of the Town"))
                .andExpect(jsonPath("$.entities.[3].time").value(108))
                .andExpect(jsonPath("$.entities.[3].dateRelease").value("30.06.1916"))
                .andExpect(jsonPath("$.entities.[3].countries").value("Guadeloupe"))
                .andExpect(jsonPath("$.entities.[3].genres").value("Боевик, Комедия, Мелодрама"))
                .andExpect(jsonPath("$.entities.[3].director").value("test4Name test4LastName"))
                .andExpect(jsonPath("$.entities.[3].roles").value("role24"))
                .andExpect(jsonPath("$.entities.[4].id").value(9L))
                .andExpect(jsonPath("$.entities.[4].name").value("Воровское шоссе"))
                .andExpect(jsonPath("$.entities.[4].originalName").value("Thieves Highway"))
                .andExpect(jsonPath("$.entities.[4].time").value(109))
                .andExpect(jsonPath("$.entities.[4].dateRelease").value("02.08.1985"))
                .andExpect(jsonPath("$.entities.[4].countries").value("Honduras"))
                .andExpect(jsonPath("$.entities.[4].genres").value("Триллер, Фантастика, Фэнтези"))
                .andExpect(jsonPath("$.entities.[4].director").value("test5Name test5LastName"))
                .andExpect(jsonPath("$.entities.[4].roles").value("role25"));
    }

    @Test
    public void getFirstPageWithParameterSortMovieFolder() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/user/folders/2/movies/page/1?sortMovieFolder=NAME")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(7)))
                .andExpect(jsonPath("$.entities.[0].id").value(2L))
                .andExpect(jsonPath("$.entities.[0].name").value("47 ронинов"))
                .andExpect(jsonPath("$.entities.[0].originalName").value("47 Ronin"))
                .andExpect(jsonPath("$.entities.[0].time").value(102))
                .andExpect(jsonPath("$.entities.[0].dateRelease").value("26.09.1935"))
                .andExpect(jsonPath("$.entities.[0].countries").value("Albania"))
                .andExpect(jsonPath("$.entities.[0].genres").value("Детектив, Комедия, Мелодрама"))
                .andExpect(jsonPath("$.entities.[0].director").value("test4Name test4LastName"))
                .andExpect(jsonPath("$.entities.[0].roles").value("role4, role6"))
                .andExpect(jsonPath("$.entities.[3].id").value(3L))
                .andExpect(jsonPath("$.entities.[3].name").value("Исход"))
                .andExpect(jsonPath("$.entities.[3].originalName").value("Exodus"))
                .andExpect(jsonPath("$.entities.[3].time").value(103))
                .andExpect(jsonPath("$.entities.[3].dateRelease").value("24.01.1925"))
                .andExpect(jsonPath("$.entities.[3].countries").value("Venezuela"))
                .andExpect(jsonPath("$.entities.[3].genres").value("Драма, Триллер, Ужасы"))
                .andExpect(jsonPath("$.entities.[3].director").value("test2Name test2LastName"))
                .andExpect(jsonPath("$.entities.[3].roles").value("role7, role8, role9"))
                .andExpect(jsonPath("$.entities.[5].id").value(5L))
                .andExpect(jsonPath("$.entities.[5].name").value("Три лица Евы"))
                .andExpect(jsonPath("$.entities.[5].originalName").value("The Three Faces of Eve"))
                .andExpect(jsonPath("$.entities.[5].time").value(105))
                .andExpect(jsonPath("$.entities.[5].dateRelease").value("20.01.2000"))
                .andExpect(jsonPath("$.entities.[5].countries").value("Guatemala"))
                .andExpect(jsonPath("$.entities.[5].genres").value("Детектив, Комедия, Мелодрама"))
                .andExpect(jsonPath("$.entities.[5].director").value("test4Name test4LastName"))
                .andExpect(jsonPath("$.entities.[5].roles").value("role14, role15"));
    }

    @Test
    public void getFirstPageWithAllParameters() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/user/folders/1/movies/page/1?itemsOnPage=3&sortMovieFolder=MY_SCORE&showType=VIEWED")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(3)))
                .andExpect(jsonPath("$.entities.[0].id").value(7L))
                .andExpect(jsonPath("$.entities.[0].name").value("Левая рука Бога"))
                .andExpect(jsonPath("$.entities.[0].originalName").value("The Left Hand of God"))
                .andExpect(jsonPath("$.entities.[0].time").value(107))
                .andExpect(jsonPath("$.entities.[0].dateRelease").value("30.07.2000"))
                .andExpect(jsonPath("$.entities.[0].countries").value("French Guiana"))
                .andExpect(jsonPath("$.entities.[0].genres").value("Детектив, Приключения, Фантастика"))
                .andExpect(jsonPath("$.entities.[0].director").value("test5Name test5LastName"))
                .andExpect(jsonPath("$.entities.[0].roles").value("role20, role21"))
                .andExpect(jsonPath("$.entities.[1].id").value(9L))
                .andExpect(jsonPath("$.entities.[1].name").value("Воровское шоссе"))
                .andExpect(jsonPath("$.entities.[1].originalName").value("Thieves Highway"))
                .andExpect(jsonPath("$.entities.[1].time").value(109))
                .andExpect(jsonPath("$.entities.[1].dateRelease").value("02.08.1985"))
                .andExpect(jsonPath("$.entities.[1].countries").value("Honduras"))
                .andExpect(jsonPath("$.entities.[1].genres").value("Триллер, Фантастика, Фэнтези"))
                .andExpect(jsonPath("$.entities.[1].director").value("test5Name test5LastName"))
                .andExpect(jsonPath("$.entities.[1].roles").value("role25"))
                .andExpect(jsonPath("$.entities.[2].id").value(1L))
                .andExpect(jsonPath("$.entities.[2].name").value("Иезавель"))
                .andExpect(jsonPath("$.entities.[2].originalName").value("Jezebel"))
                .andExpect(jsonPath("$.entities.[2].time").value(101))
                .andExpect(jsonPath("$.entities.[2].dateRelease").value("08.05.1938"))
                .andExpect(jsonPath("$.entities.[2].countries").value("Slovakia"))
                .andExpect(jsonPath("$.entities.[2].genres").value("Драма, Ужасы, Фантастика"))
                .andExpect(jsonPath("$.entities.[2].director").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.entities.[2].roles").value("role1, role3"));
    }

    @Test
    public void getLastPageWithAllParameters() throws Exception {
        accessToken = obtainNewAccessToken("user1@mail.ru", "101", mockMvc);
        mockMvc.perform(get("/api/user/folders/3/movies/page/3?itemsOnPage=3&sortMovieFolder=YEAR&showType=VIEWED")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(3)))
                .andExpect(jsonPath("$.entities.[0].id").value(3L))
                .andExpect(jsonPath("$.entities.[0].name").value("Исход"))
                .andExpect(jsonPath("$.entities.[0].originalName").value("Exodus"))
                .andExpect(jsonPath("$.entities.[0].time").value(103))
                .andExpect(jsonPath("$.entities.[0].dateRelease").value("24.01.1925"))
                .andExpect(jsonPath("$.entities.[0].countries").value("Venezuela"))
                .andExpect(jsonPath("$.entities.[0].genres").value("Драма, Триллер, Ужасы"))
                .andExpect(jsonPath("$.entities.[0].director").value("test2Name test2LastName"))
                .andExpect(jsonPath("$.entities.[0].roles").value("role7, role8, role9"))
                .andExpect(jsonPath("$.entities.[1].id").value(11L))
                .andExpect(jsonPath("$.entities.[1].name").value("Крик совы"))
                .andExpect(jsonPath("$.entities.[1].originalName").value("The Cry of the Owl"))
                .andExpect(jsonPath("$.entities.[1].time").value(111))
                .andExpect(jsonPath("$.entities.[1].dateRelease").value("28.01.1922"))
                .andExpect(jsonPath("$.entities.[1].countries").value("Kyrgyzstan"))
                .andExpect(jsonPath("$.entities.[1].genres").value("Комедия, Мелодрама, Фэнтези"))
                .andExpect(jsonPath("$.entities.[1].director").value("test1Name test1LastName"))
                .andExpect(jsonPath("$.entities.[1].roles").value("role31, role32"))
                .andExpect(jsonPath("$.entities.[2].id").value(8L))
                .andExpect(jsonPath("$.entities.[2].name").value("Весь город говорит"))
                .andExpect(jsonPath("$.entities.[2].originalName").value("The Talk of the Town"))
                .andExpect(jsonPath("$.entities.[2].time").value(108))
                .andExpect(jsonPath("$.entities.[2].dateRelease").value("30.06.1916"))
                .andExpect(jsonPath("$.entities.[2].countries").value("Guadeloupe"))
                .andExpect(jsonPath("$.entities.[2].genres").value("Боевик, Комедия, Мелодрама"))
                .andExpect(jsonPath("$.entities.[2].director").value("test4Name test4LastName"))
                .andExpect(jsonPath("$.entities.[2].roles").value("role24"));
    }
}
