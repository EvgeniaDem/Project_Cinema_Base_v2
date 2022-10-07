package com.kata.cinema.base.dao.dto.impl;

import com.kata.cinema.base.dao.dto.NewsResponseDtoPaginationDao;
import com.kata.cinema.base.dao.entity.impl.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.response.NewsResponseDto;
import com.kata.cinema.base.models.entitys.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("newsResponseForMovie")
public class NewsResponseDtoPaginationDaoImplForMovie extends AbstractDaoImpl<Long, News> implements NewsResponseDtoPaginationDao {
    @Override
    public List<NewsResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        return entityManager.createQuery("select new com.kata.cinema.base.models.dto.response.NewsResponseDto(" +
                        "n.id, n.rubric, n.date, n.title, m.description, n.previewUrl, (select cast(count(com) as int) from Comment com join com.news.movies mov where mov.id = :id)" +
                        ") from News n join n.movies m where m.id = :id", NewsResponseDto.class)
                .setParameter("id", parameters.get("id"))
                .setMaxResults((Integer) parameters.get("count"))
                .getResultList();
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(n) from News n join n.movies m where m.id = :id", Long.class)
                .setParameter("id", parameters.get("id"))
                .getSingleResult();
    }
}
