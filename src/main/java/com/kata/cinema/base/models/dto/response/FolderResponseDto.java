package com.kata.cinema.base.models.dto.response;

import com.kata.cinema.base.models.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FolderResponseDto {
    Long id;
    String name;
    Category category;
    Integer countMovies;
}
