package com.kata.cinema.base.webapp.controllers.registrationRestController;

import com.kata.cinema.base.AbstractTest;
import com.kata.cinema.base.models.dto.request.UserRegistrationRequestDto;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static com.kata.cinema.base.webapp.util.IntegrationTestingAccessTokenUtil.obtainNewAccessToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(value = "/data/sql/controller/registrationRestController/registrationInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/data/sql/controller/registrationRestController/registrationClean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class RegistrationTest extends AbstractTest {

    private static String accessToken;

    @Test
    void registration() throws Exception {
        accessToken = obtainNewAccessToken("admin@mail.ru", "admin", mockMvc);

        UserRegistrationRequestDto userRegistrationRequestDto = new UserRegistrationRequestDto("admin@mail.ru", "test_first_Name", "test_last_name", "admin11", "admin11", LocalDate.now());
        this.mockMvc.perform(post("/api/registration")
                        .header("Authorization", "Bearer " + accessToken)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRegistrationRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}