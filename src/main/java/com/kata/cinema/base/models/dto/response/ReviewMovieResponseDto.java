package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.dto.PageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewMovieResponseDto {
    private Integer count;
    private Integer countPositive;
    private Integer countNegative;
    private Integer countNeutral;

    private PageDto<ReviewResponseDto> page;

    public ReviewMovieResponseDto(Integer count, Integer countPositive, Integer countNegative, Integer countNeutral) {
        this.count = count;
        this.countPositive = countPositive;
        this.countNegative = countNegative;
        this.countNeutral = countNeutral;
    }
}
