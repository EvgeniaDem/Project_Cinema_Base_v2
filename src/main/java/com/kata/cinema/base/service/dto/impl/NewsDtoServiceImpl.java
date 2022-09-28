package com.kata.cinema.base.service.dto.impl;

import com.kata.cinema.base.dao.entity.NewsDao;
import com.kata.cinema.base.models.dto.response.NewsBodyResponseDto;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.entity.AbstractServiceImpl;
import com.kata.cinema.base.service.dto.NewsDtoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsDtoServiceImpl extends AbstractServiceImpl<Long, News> implements NewsDtoService {
    private final NewsDao newsDao;

    public NewsDtoServiceImpl(NewsDao newsRepository) {
        super(newsRepository);
        this.newsDao = newsRepository;
    }

    @Override
    public List<NewsTitleResponseDto> getLatestNews() {
        return newsDao.findLatestNews();
    }

    @Override
    public List<NewsResponseDto> findByDateBetweenAndRubric(LocalDate dateStart, LocalDate dateEnd, Rubric rubric) {
        return newsDao.findByDateBetweenAndRubric(dateStart, dateEnd, rubric);
    }

    @Override
    public NewsBodyResponseDto getByIdNewsBodyPageInfo(Long id) {
        return newsDao.getByIdNewsBody(id);
    }
}
