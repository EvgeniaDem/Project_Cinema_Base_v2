package com.kata.cinema.base.models.dto.request;

import com.kata.cinema.base.models.enums.CollectionType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CollectionRequestDto {

    private String name;
    private CollectionType type;

    public CollectionRequestDto() {
    }
}
