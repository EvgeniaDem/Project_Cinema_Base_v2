package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.NewsDao;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.dto.response.NewsTitleResponseDto;
import com.kata.cinema.base.models.entitys.News;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsServiceImpl extends AbstractServiceImpl<Long, News> implements NewsService {
    private final NewsDao newsDao;

    public NewsServiceImpl(NewsDao newsRepository) {
        super(newsRepository);
        this.newsDao = newsRepository;
    }

    @Transactional
    @Override
    public void save(News news) {
        newsDao.create(news);
    }

    @Override
    public List<NewsTitleResponseDto> getLatestNews() {
        return newsDao.findLatestNews();
    }

    @Override
    public List<NewsResponseDto> findByDateBetweenAndRubric(LocalDate dateStart, LocalDate dateEnd, Rubric rubric) {
        return newsDao.findByDateBetweenAndRubric(dateStart, dateEnd, rubric);
    }


}
