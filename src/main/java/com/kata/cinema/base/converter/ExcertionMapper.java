package com.kata.cinema.base.converter;

import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;
import com.kata.cinema.base.models.entitys.Excertion;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ExcertionMapper extends Converter<ExcertionRequestDto, Excertion> {
    Excertion toExcertion(ExcertionRequestDto requestDto);
}
