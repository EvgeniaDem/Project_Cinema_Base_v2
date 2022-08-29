package com.kata.cinema.base.models.dto;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.*;

@Getter
@Setter
public class FolderMovieDto {

    public Long id;
    public Category category;
    public Privacy privacy;
    public String name;
    public String description;

    public FolderMovieDto(Long id, Category category, Privacy privacy, String name, String description) {
        this.id = id;
        this.category = category;
        this.privacy = privacy;
        this.name = name;
        this.description = description;
    }
}
