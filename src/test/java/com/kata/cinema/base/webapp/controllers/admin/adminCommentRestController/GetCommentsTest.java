package com.kata.cinema.base.webapp.controllers.admin.adminCommentRestController;

import com.kata.cinema.base.AbstractTest;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/adminCommentRestController/GetCommentsInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/adminCommentRestController/GetCommentsClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GetCommentsTest extends AbstractTest {

    private static String accessToken;

    @Test
    public void getLastPageWithComments() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(get("/api/admin/comments/moderator/page/2?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(2)))
                .andExpect(jsonPath("$.entities.[0].id").value(6L))
                .andExpect(jsonPath("$.entities.[0].message").value("test6"))
                .andExpect(jsonPath("$.entities.[0].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[0].level").value(101))
                .andExpect(jsonPath("$.entities.[0].date").value("03.10.2017"))
                .andExpect(jsonPath("$.entities.[0].rating").value(-3))
                .andExpect(jsonPath("$.entities.[0].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[0].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[0].user.avatarUrl").value("url1"))
                .andExpect(jsonPath("$.entities.[1].id").value(7L))
                .andExpect(jsonPath("$.entities.[1].message").value("test7"))
                .andExpect(jsonPath("$.entities.[1].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[1].level").value(101))
                .andExpect(jsonPath("$.entities.[1].date").value("03.10.2016"))
                .andExpect(jsonPath("$.entities.[1].rating").value(0))
                .andExpect(jsonPath("$.entities.[1].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[1].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[1].user.avatarUrl").value("url1"));

    }

    @Test
    public void getFirstPageWithComments() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);
        mockMvc.perform(get("/api/admin/comments/moderator/page/1?itemsOnPage=5")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entities", hasSize(5)))
                .andExpect(jsonPath("$.entities.[0].id").value(1L))
                .andExpect(jsonPath("$.entities.[0].message").value("test1"))
                .andExpect(jsonPath("$.entities.[0].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[0].level").value(101))
                .andExpect(jsonPath("$.entities.[0].date").value("03.10.2022"))
                .andExpect(jsonPath("$.entities.[0].rating").value(3))
                .andExpect(jsonPath("$.entities.[0].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[0].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[0].user.avatarUrl").value("url1"))
                .andExpect(jsonPath("$.entities.[1].id").value(2L))
                .andExpect(jsonPath("$.entities.[1].message").value("test2"))
                .andExpect(jsonPath("$.entities.[1].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[1].level").value(101))
                .andExpect(jsonPath("$.entities.[1].date").value("03.10.2021"))
                .andExpect(jsonPath("$.entities.[1].rating").value(1))
                .andExpect(jsonPath("$.entities.[1].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[1].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[1].user.avatarUrl").value("url1"))
                .andExpect(jsonPath("$.entities.[2].id").value(3L))
                .andExpect(jsonPath("$.entities.[2].message").value("test3"))
                .andExpect(jsonPath("$.entities.[2].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[2].level").value(101))
                .andExpect(jsonPath("$.entities.[2].date").value("03.10.2020"))
                .andExpect(jsonPath("$.entities.[2].rating").value(0))
                .andExpect(jsonPath("$.entities.[2].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[2].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[2].user.avatarUrl").value("url1"))
                .andExpect(jsonPath("$.entities.[3].id").value(4L))
                .andExpect(jsonPath("$.entities.[3].message").value("test4"))
                .andExpect(jsonPath("$.entities.[3].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[3].level").value(101))
                .andExpect(jsonPath("$.entities.[3].date").value("03.10.2019"))
                .andExpect(jsonPath("$.entities.[3].rating").value(1))
                .andExpect(jsonPath("$.entities.[3].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[3].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[3].user.avatarUrl").value("url1"))
                .andExpect(jsonPath("$.entities.[4].id").value(5L))
                .andExpect(jsonPath("$.entities.[4].message").value("test5"))
                .andExpect(jsonPath("$.entities.[4].parentId").value(101L))
                .andExpect(jsonPath("$.entities.[4].level").value(101))
                .andExpect(jsonPath("$.entities.[4].date").value("03.10.2018"))
                .andExpect(jsonPath("$.entities.[4].rating").value(3))
                .andExpect(jsonPath("$.entities.[4].user.id").value(1L))
                .andExpect(jsonPath("$.entities.[4].user.login").value("login1"))
                .andExpect(jsonPath("$.entities.[4].user.avatarUrl").value("url1"));
    }
}