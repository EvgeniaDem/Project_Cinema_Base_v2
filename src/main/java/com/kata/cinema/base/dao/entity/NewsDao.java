package com.kata.cinema.base.dao.entity;

import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;

import java.time.LocalDate;
import java.util.List;

public interface NewsDao extends AbstractDao<Long, News> {

    List<NewsTitleResponseDto> findLatestNews();

    List<NewsResponseDto> findByDateBetweenAndRubric(LocalDate dateStart, LocalDate dateEnd, Rubric rubric);
}
