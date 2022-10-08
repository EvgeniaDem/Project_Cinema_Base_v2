package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.request.ExcertionRequestDto;

public interface ExcertionService {
    void createExcertionWithPersonId(ExcertionRequestDto excertionRequestDto, Long personId);

    void createExcertionWithMovieId(ExcertionRequestDto excertionRequestDto, Long movieId);

    void deleteExcertionById(Long excertionId);

    void updateExcertion(ExcertionRequestDto excertionRequestDto, Long excertionId);
}
