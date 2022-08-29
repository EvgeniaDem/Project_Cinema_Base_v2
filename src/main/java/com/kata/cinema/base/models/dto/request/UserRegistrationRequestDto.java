package com.kata.cinema.base.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserRegistrationRequestDto {

    @NotBlank
    @Size(min = 6, max = 20)
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String firstName;


    private String lastName;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(min = 6, max = 20)
    private String confirmPassword;

    private LocalDate birthday;

}
