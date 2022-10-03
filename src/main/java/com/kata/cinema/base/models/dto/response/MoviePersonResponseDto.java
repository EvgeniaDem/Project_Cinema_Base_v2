package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviePersonResponseDto {

    @JsonIgnore
    private String professionId;
    private Long personId;
    private String fullName;
    private String originalFullName;
    private TypeCharacter type;
    private String nameCharacter;

}
