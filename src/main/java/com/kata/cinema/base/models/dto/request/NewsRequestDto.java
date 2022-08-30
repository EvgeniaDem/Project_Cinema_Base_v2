package com.kata.cinema.base.models.dto.request;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class NewsRequestDto {
    private Rubric rubric;
    private String title;
    private String htmlBody;
}
