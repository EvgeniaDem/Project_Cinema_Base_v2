package com.kata.cinema.base.service.dto;

import com.kata.cinema.base.models.dto.PageDto;
import com.kata.cinema.base.models.dto.response.ExcertionResponseDto;


public interface ExcertionResponseDtoPaginationService extends PaginationDtoService<ExcertionResponseDto> {
    PageDto<ExcertionResponseDto> getPaginationExcertionResponseDtoForPerson(Long personId, Integer pageNumber, Integer itemsOnPage);

    PageDto<ExcertionResponseDto> getPaginationExcertionResponseDtoForMovie(Long movieId, Integer pageNumber, Integer itemsOnPage);
}
