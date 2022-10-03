package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.entitys.StudioPerformance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductionMovieStudioResponseDto {
    private Long id;
    private String name;
    private StudioPerformance performance;
}
