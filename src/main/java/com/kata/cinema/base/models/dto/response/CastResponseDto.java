package com.kata.cinema.base.models.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastResponseDto {
    @JsonIgnore
    private Long movieId;
    private String professionId;
    private String professionName;
    private List<MoviePersonResponseDto> persons;

    public CastResponseDto(String professionId, String professionName) {
        this.professionId = professionId;
        this.professionName = professionName;
    }

    public CastResponseDto(Long movieId, String professionId, String professionName) {
        this.movieId = movieId;
        this.professionId = professionId;
        this.professionName = professionName;
    }
}
