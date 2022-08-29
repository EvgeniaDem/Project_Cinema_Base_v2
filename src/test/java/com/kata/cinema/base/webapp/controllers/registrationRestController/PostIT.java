package com.kata.cinema.base.webapp.controllers.registrationRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.UserRegistrationRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
class PostIT extends AbstractIT {

    @Test
    void registration() throws Exception {
        UserRegistrationRequestDto userRegistrationRequestDto = new UserRegistrationRequestDto("test@mail.ru", "test_first_Name", "test_last_name", "testPassword", "testPassword", LocalDate.now());
        this.mockMvc.perform(post("/api/registration")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRegistrationRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}