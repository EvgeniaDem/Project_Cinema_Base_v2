package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FolderMovieDto {

    private Long id;
    private Category category;
    private Privacy privacy;
    private String name;
    private String description;

    public FolderMovieDto(Long id, Category category, Privacy privacy, String name, String description) {
        this.id = id;
        this.category = category;
        this.privacy = privacy;
        this.name = name;
        this.description = description;
    }
}
