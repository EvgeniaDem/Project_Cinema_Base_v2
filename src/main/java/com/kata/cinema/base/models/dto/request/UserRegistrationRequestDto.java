package com.kata.cinema.base.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequestDto {

    @NotBlank
    private String email;

    @NotBlank
    private String firstName;


    private String lastName;

    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(min = 6, max = 20)
    private String confirmPassword;

    private LocalDate birthday;

}