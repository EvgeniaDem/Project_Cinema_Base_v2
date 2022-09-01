package com.kata.cinema.base.service.entity;

import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;

import java.time.LocalDate;
import java.util.List;

public interface NewsService extends AbstractService<Long, News> {

    //TODO вынести методы в NewsDtoService(реализацию тоже)
    List<NewsTitleResponseDto> getLatestNews();

    List<NewsResponseDto> findByDateBetweenAndRubric(LocalDate dateStart, LocalDate dateEnd, Rubric rubric);
}
