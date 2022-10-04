package com.kata.cinema.base.converter;

import com.kata.cinema.base.models.dto.request.ProductionStudioRequestDto;
import com.kata.cinema.base.models.entitys.ProductionStudio;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ProductionStudioMapper extends Converter<ProductionStudioRequestDto, ProductionStudio> {
    ProductionStudio toProductionStudio(ProductionStudioRequestDto requestDto);
}
